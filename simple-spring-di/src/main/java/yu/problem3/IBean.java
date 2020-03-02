package yu.problem3;

import org.springframework.scheduling.annotation.Async;

@Async
public interface IBean {

    String test() throws Exception;
}
