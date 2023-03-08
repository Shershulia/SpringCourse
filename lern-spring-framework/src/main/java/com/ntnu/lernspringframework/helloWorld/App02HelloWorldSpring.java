package com.ntnu.lernspringframework.helloWorld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
        {
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCalls"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person4Qualifier"));


            System.out.println();
            System.out.println(context.getBean("newAddress"));
            System.out.println(context.getBean(Adress.class));

            System.out.println("All beans:");
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);


        }




    }
}
