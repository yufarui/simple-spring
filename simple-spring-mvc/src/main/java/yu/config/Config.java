package yu.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import yu.filter.SimpleFilter;

@Configuration
public class Config {

	/**
	 * @see org.springframework.web.filter.CharacterEncodingFilter
	 * 过滤器修改请求和响应的编码
	 */
	@Bean
	public FilterRegistrationBean<SimpleFilter> simpleFilter() {
		FilterRegistrationBean<SimpleFilter> filterRegBean = new FilterRegistrationBean<>();
		filterRegBean.setFilter(new SimpleFilter());
		filterRegBean.addUrlPatterns("/simple/*");
		filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
		return filterRegBean;
	}
}
