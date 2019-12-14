package yu.step4.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ConditionalOnExpression("${spring.batch.job.enabled}.equals(false)")
@Configuration
@EnableBatchProcessing
public class JobFlowConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private Step step1;
    @Autowired
    private Step step2;
    @Autowired
    private Step step3;

    // 顺序执行,在step2 中已经描述

    // 分支执行
    @Bean
    public Job job1() {
        return this.jobBuilderFactory.get("job1")
                //启动时执行的step
                .start(step2)
                // 默认跳转到stepB
                .on(ExitStatus.COMPLETED.getExitCode()).to(step1)
                // 当返回的ExitStatus为"FAILED"时，执行。
                .from(step2).on(ExitStatus.FAILED.getExitCode()).to(step3)
                .end()
                .build();
    }

    // step 退出机制,观察 batch_step_execution数据库 中 EXIT_CODE
    @Bean
    public Job job2() {
        return this.jobBuilderFactory.get("job2")
                //启动时执行的step
                .start(step1)
                .next(step2)
                // fail 直接结束
                .on(ExitStatus.FAILED.getExitCode()).end()
                .on(ExitStatus.COMPLETED.getExitCode()).to(step1)
                .end()
                .build();
    }

    // step fail 退出
    @Bean
    public Job job3() {
        return this.jobBuilderFactory.get("job3")
                //启动时执行的step
                .start(step1)
                .next(step2)
                // 尝试下 用fail退出
                .on(ExitStatus.FAILED.getExitCode()).fail()
                .on(ExitStatus.COMPLETED.getExitCode()).to(step1)
                .end()
                .build();
    }

    // 在指定的节点中断, 以方便错误点重试
    // 当然想要重试成功,必须是同一个job,所以 jobParamters 必须相同,请注释jobController中部分代码
    // 注意观察 batch_step_execution version
    @Bean
    public Job job4() {
        return this.jobBuilderFactory.get("job4")
                //启动时执行的step
                .start(step2)
                // 尝试下 用fail退出
                .on(ExitStatus.FAILED.getExitCode())
                .stopAndRestart(step2)
                .end()
                .build();
    }

    // 程序化流程的分支 step4中 EVENODDDecider 可以视为案例执行
    // job5 也可以帮助理解,可以自己写一个新的JobExecutionDecider
    @Bean
    public Job job5(JobExecutionDecider evenOddDecider) {
        return this.jobBuilderFactory.get("job5")
                .start(step1)
                .next(evenOddDecider).on("FAILED").to(step2)
                .from(evenOddDecider).on("COMPLETED").to(step3)
                .end()
                .build();
    }

    // 流程分裂,异步执行
    @Bean
    public Job job6() {
        Flow flow1 = new FlowBuilder<SimpleFlow>("flow1")
                .start(step1)
                .build();//并行流程1

        Flow flow2 = new FlowBuilder<SimpleFlow>("flow2")
                .start(step3)
                .build();//并行流程2

        return this.jobBuilderFactory.get("job6")
                .start(flow1)
                .split(new SimpleAsyncTaskExecutor()) //创建一个异步执行任务
                .add(flow2)
                .next(step2).on(ExitStatus.FAILED.getExitCode()).fail()//2个分支执行完毕之后再执行step1。
                .end()
                .build();
    }

}
