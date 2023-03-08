package com.ntnu.lernspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age, Adress adress){};
record Adress(String country, String city){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Name";
    }
    @Bean
    public int age() {
        return 10;
    }
    @Bean
    public Person person(){
        return new Person("Ivan",20, new Adress("Hello","World"));
    }

    @Bean
    public Person person2MethodCalls(){
        return new Person(name(),age(),address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Adress newAddress){
        return new Person(name,age,newAddress);
    }
    @Bean
    public Person person4Qualifier(String name, int age,@Qualifier("addressOneQualifier") Adress address){
        return new Person(name,age,address);
    }
    @Bean(name = "newAddress")
    @Qualifier("addressOneQualifier")
    public Adress address(){
        return new Adress("Norway","Trondheim");
    }
    @Bean(name = "newAddress2")
    @Primary
    public Adress address2(){
        return new Adress("Second","Address");
    }
}
