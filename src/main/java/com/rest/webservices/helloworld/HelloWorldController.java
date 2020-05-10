package com.rest.webservices.helloworld;

import com.rest.webservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/sik")
    public String helloWorldInt() {
         return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
