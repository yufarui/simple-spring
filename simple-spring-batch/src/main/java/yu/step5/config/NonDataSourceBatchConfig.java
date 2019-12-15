package yu.step5.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 自定义BatchConfigurer
 * JobRepository、JobLauncher、JobRegistry、PlatformTransactionManager、JobBuilderFactory以及StepBuilderFactory
 *
 * 若希望观察内存处理方式 可以观察
 * @see org.springframework.batch.core.repository.dao.MapJobInstanceDao 等系列类中属性
 */
public class NonDataSourceBatchConfig extends DefaultBatchConfigurer {

    /**
     * @see DefaultBatchConfigurer#initialize()
     * 观察内存对象 jobRepository
     * @param dataSource 忽视配置中的 datasource
     */
    @Override
    @Autowired(required = false)
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(null);
    }

    @Override
    public PlatformTransactionManager getTransactionManager() {
        return new ResourcelessTransactionManager();
    }

//    @Autowired
//    private DataSource dataSource;
//
//    protected JobRepository createJobRepository() throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(super.getTransactionManager());
//        factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
//        return factory.getObject();
//    }
}
