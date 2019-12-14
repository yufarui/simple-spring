package yu.step4.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * step2 的升级版,可控制流程(step)的作业
 * 程序化流程的分支, 参考 jobflowConfig中job5
 */
@ConditionalOnExpression("${spring.batch.job.enabled}.equals(false)")
@Configuration
@EnableBatchProcessing
public class FlowDecisionConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job flowDecisonDemoJob(JobExecutionDecider evenOddDecider) {
        return jobBuilderFactory.get("flowDecisonDemoJob")
                .start(firstStep())
                .next(evenOddDecider).on("EVEN").to(evenStep())
                .from(evenOddDecider).on("ODD").to(oddStep())
                .end()
                .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("firstStep");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step oddStep() {
        return stepBuilderFactory.get("oddStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("oddStep");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step evenStep() {
        return stepBuilderFactory.get("evenStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("evenStep");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public JobExecutionDecider myDecider() {
        return new EvenOddDecider();
    }
}
