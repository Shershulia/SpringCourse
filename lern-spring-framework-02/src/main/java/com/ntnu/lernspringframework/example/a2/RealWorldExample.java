package com.ntnu.lernspringframework.example.a2;

import com.ntnu.lernspringframework.game.GamingAppLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldExample {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RealWorldExample.class)){
            System.out.println(context.getBean(BusinessCalculation.class).findMax());
        }

    }
}
