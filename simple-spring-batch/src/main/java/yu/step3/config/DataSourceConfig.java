package yu.step3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // 读取 配置的spring.database 开头的配置信息
    // com.zaxxer.hikari HikariDataSource 所以 配置参数 需要按此配置
    // 配置 数据源
    @Bean
    @ConfigurationProperties(prefix = "spring.database")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // 测试数据源配置正确
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
