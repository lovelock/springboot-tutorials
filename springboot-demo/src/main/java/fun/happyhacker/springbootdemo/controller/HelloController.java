package fun.happyhacker.springbootdemo.controller;

import fun.happyhacker.springbootdemo.configuration.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private CustomConfig customConfig;

    @GetMapping("/hello")
    public String hello() {
        return customConfig.getWorld();
    }
}
