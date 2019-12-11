package yu.step5.config;

import org.springframework.batch.core.configuration.annotation.BatchConfigurationSelector;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
    /**
     * 使用 自己的配置
     * 默认 使用BasicBatchConfigurer
     * @see BatchConfigurationSelector#BatchConfigurationSelector()
     * @return
     */
    @Bean
    @ConditionalOnExpression("${spring.batch.job.enabled:true}")
    public BatchConfigurer noSourceBatchConfigurer() {
        return new NonDataSourceBatchConfig();
    }

}
