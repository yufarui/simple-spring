package yu.lombok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LogBean {

    public void logAllLevel() {
        log.debug("slfj log debug");
        log.info("slfj log info");
        log.warn("slfj log warn");
        log.error("slfj log error");
    }
}
