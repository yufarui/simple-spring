package yu.logfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerFactoryBean {

    Logger log = LoggerFactory.getLogger(getClass());

    public void logAlllevel() {
        log.debug("LoggerFactory log debug");
        log.info("LoggerFactory log info");
        log.warn("LoggerFactory log warn");
        log.error("LoggerFactory log error");
    }
}
