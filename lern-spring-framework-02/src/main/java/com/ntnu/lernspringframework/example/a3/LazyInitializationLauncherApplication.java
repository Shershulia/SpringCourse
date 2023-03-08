package com.ntnu.lernspringframework.example.a3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}
@Component
@Lazy
class ClassB{

    private ClassA classA;
    public ClassB(ClassA classA){
        System.out.println("Class B initialization");
        this.classA=classA;
    }
    public void hello(){
        System.out.println("Hello");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
            System.out.println("Context");
            context.getBean(ClassB.class).hello();

        }

    }
}
