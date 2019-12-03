package yu.step3.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Value("${name}")
    private String name;

    @Bean
    public Object beanA() {
        // 测试 启动 step3 环境
        System.out.println("启动环境为:" + "{" + name + "}");
        return new Object();
    }

    /**
     * 自动将 JobConfig 中job登记
     */
    @Bean
    public ApplicationContextFactory jobContext() {
        return new GenericApplicationContextFactory(JobConfig.class);
    }

}
