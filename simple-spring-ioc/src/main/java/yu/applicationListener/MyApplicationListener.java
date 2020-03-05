package yu.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("onApplicationEvent 监听到事件 " + event);
	}

	@EventListener
	public void handle(ApplicationEvent event) {
		System.out.println("@EventListener 监听到事件 " + event);
	}
}
