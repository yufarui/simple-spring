package yu.step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.step3.service.FirstService;

import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/jdbc")
    public Map runJob1(){

        return firstService.test();
    }
}
