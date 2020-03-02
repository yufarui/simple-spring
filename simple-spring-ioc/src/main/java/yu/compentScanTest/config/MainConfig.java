package yu.compentScanTest.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import yu.compentScanTest.dao.NonUseBean;

@Configuration
//@ComponentScan(basePackages = "yu.compentScanTest")
//@ComponentScan(basePackages = "yu.compentScanTest", excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class),
//        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,value = NonUseService.class)
//})
@ComponentScan(basePackages = "yu.compentScanTest",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = CustomFilter.class),
        }, useDefaultFilters = false)
public class MainConfig {

    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public NonUseBean diffNonUseBean() {
        // 这里存在一个问题: 使用 includeFilters 会赖加载 basePackages 中所有的bean
        Object nonUseBean = beanFactory.getBean("nonUseBean");
        System.out.println(nonUseBean != null);
        return new NonUseBean();
    }
}
