package com.boot.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
//@MapperScan("com.boot.create")
public class MyBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBootApplication.class, args);
    }

}
