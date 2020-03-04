package yu.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("监听到事件" + event);
	}
}
