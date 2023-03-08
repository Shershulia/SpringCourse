package com.ntnu.lernspringframework.example.a5;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class someClass{
    private someDependecy someDependecy;

    public someClass(someDependecy someDependecy) {
        this.someDependecy = someDependecy;
        System.out.println("Initialized");
    }
    @PostConstruct
    public void initialise(){
        someDependecy.getReady();
    }
    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleaned up");
    }
}
@Component
class someDependecy{

    public void getReady() {
        System.out.println("Dependency is ready");
    }
}
@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)){
        }

    }
}
