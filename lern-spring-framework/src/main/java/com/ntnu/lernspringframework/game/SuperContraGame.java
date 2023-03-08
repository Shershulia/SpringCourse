package com.ntnu.lernspringframework.game;

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
