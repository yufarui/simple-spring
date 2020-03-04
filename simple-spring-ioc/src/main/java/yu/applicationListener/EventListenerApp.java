package yu.applicationListener;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EventListenerApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventListenerApp.class);

		//手动发布一个事件
		ctx.publishEvent(new ApplicationEvent("我手动发布了一个事件") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});

		//容器关闭也发布事件
		ctx.close();
	}
}
