package com.itheima.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name}")
    String name;

    @Value("${address[0]}")
    int address0;

    @Value("${address[1]}")
    int address1;

    @Value("${msg1}")
    String msg1;

    @Value("${msg2}")
    String msg2;

    @Autowired
    private Environment env;

    @Autowired
    private Person p1;

    @RequestMapping("/hello2")
    public String hello2(){
        System.out.println(name);
        System.out.println(address0);
        System.out.println(address1);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("------------------------");
        System.out.println(env.getProperty("address[0]"));
        System.out.println("------------------------");
        System.out.println(p1);
        String[] address = p1.getAddress();
        for(String s : address){
            System.out.println(s);
        }
        return "Hello SpringBoot2!";
    }


    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
