package com.ntnu.lernspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("gameQualifier")
public class SuperContraGame implements GamingConsole{
    public void up(){
        System.out.println("Up");
    }
    public void down(){
        System.out.println("Set down");
    }
    public void left(){
        System.out.println("Go back");
    }
    public void right(){
        System.out.println("Shot a bullet");
    }
}
