package yu.compentScanTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
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

}
