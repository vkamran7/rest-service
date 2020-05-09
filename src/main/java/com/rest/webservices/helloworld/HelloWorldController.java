package com.rest.webservices.helloworld;

import com.rest.webservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean getBean() {
        return new HelloWorldBean("Salam qaqa");
    }

    @GetMapping(path = "/hello-world-bean/path-var/{name}")
    public HelloWorldBean getBean2(@PathVariable String name) {
        return new HelloWorldBean(String.format("Salam, %s qaqa", name));
    }
}
