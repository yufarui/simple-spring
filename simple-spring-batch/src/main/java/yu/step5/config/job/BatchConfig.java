package yu.step5.config.job;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    /*
    * 自定义BatchConfigurer
    * JobRepository、JobLauncher、JobRegistry、PlatformTransactionManager、JobBuilderFactory以及StepBuilderFactory
    */
    @Bean
    public BatchConfigurer batchConfigurer() {
        return new DefaultBatchConfigurer() {
            @Override
            protected JobRepository createJobRepository() throws Exception {
                MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean();
//                factory.setTransactionManager(transactionManager);
                return factory.getObject();
            }
        };
    }

    /**
     * 可以配置 内存级存储,不再需要设置 数据库
     * 当然放在内存,是不适合 分布式系统的
     */

}
