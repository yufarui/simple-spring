package yu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import yu.interceptor.SimpleInterceptor;
import yu.interceptor.StopWatchHandlerInterceptor;

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {

	@Autowired
	private SimpleInterceptor simpleInterceptor;

	@Autowired
	private StopWatchHandlerInterceptor stopWatchHandlerInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);

		registry
			.addInterceptor(stopWatchHandlerInterceptor)
			.addPathPatterns("/**");

		registry
			.addInterceptor(simpleInterceptor)
			.addPathPatterns("/simple/*");
	}
}
