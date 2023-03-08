package com.ntnu.lernspringframework.example.a7;

import com.ntnu.lernspringframework.game.GameRunner;
import com.ntnu.lernspringframework.game.GamingAppLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class XMLConfigurationLauncherApplication {
    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("context.xml")){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            context.getBean(GameRunner.class).run();
        }

    }
}
