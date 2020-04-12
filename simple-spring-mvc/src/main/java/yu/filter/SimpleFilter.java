package yu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SimpleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Inside SimpleFilter: "+ req.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
