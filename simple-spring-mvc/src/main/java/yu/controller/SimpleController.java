package yu.controller;

import org.springframework.web.bind.annotation.*;
import yu.model.SimpleDTO;

import java.util.Date;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @GetMapping("/test")
    public String test() {
        return "hello simple world";
    }

    @GetMapping("/date")
    public Date testDate(@RequestParam Date date) {
        return date;
    }

    @GetMapping("/error")
    public void testError() {
        throw new RuntimeException("我是个简单错误");
    }

    @PostMapping("/model")
    public SimpleDTO testDate(@RequestBody SimpleDTO simpleDTO) {
        return simpleDTO;
    }

    @GetMapping("/{code}")
    public String testCode(@PathVariable("code") String code) {
        return "hello simple world" + code;
    }
}
