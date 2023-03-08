package com.ntnu.lernspringframework.example.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class YourBusiness{
    //1 method field
    Dependency1 dependency1;

    Dependency2 dependency2;

    //2 method setters
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }
    //3rd method constructor
   // @Autowired
    public YourBusiness(Dependency1 dependency1, Dependency2 dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 +" and "+dependency2;
    }

}
@Component
class Dependency1{

}
@Component
class Dependency2{

}
@Configuration
@ComponentScan
public class DependencyInjLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusiness.class));
        }

    }
}
