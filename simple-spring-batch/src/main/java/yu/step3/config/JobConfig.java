package yu.step3.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.DefaultJobLoader;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.batch.core.configuration.support.JobLoader;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableBatchProcessing
public class JobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobLaunchJob() {
        return jobBuilderFactory.get("jobLaunchJob")
                .start(jobLaunchStep())
                .build();
    }

    @Bean
    public Step jobLaunchStep() {
        return stepBuilderFactory.get("jobLaunchStep")
                .tasklet((contribution, context) -> {
                    System.out.println("jobLaunchJob jobOperatorStep excute");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Job jobOperatorJob() {
        return jobBuilderFactory.get("jobOperatorJob")
                .start(jobOperatorStep())
                .build();
    }

    @Bean
    public Step jobOperatorStep() {
        return stepBuilderFactory.get("jobOperatorStep")
                .tasklet((contribution, context) -> {
                    System.out.println("jobOperatorJob jobOperatorStep excute");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Job jobScheduledJob() {

        JobParameters params = new JobParameters();
        SimpleJob simpleJob = new SimpleJob();

        return jobBuilderFactory
                .get("jobScheduledJob")
                .start(jobScheduledStep())
                // 设置 the next JobParameters in a sequence
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step jobScheduledStep() {
        return stepBuilderFactory.get("jobScheduledStep")
                .tasklet((contribution, context) -> {
                    System.out.println("{jobScheduledJob jobScheduledStep excute}");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
