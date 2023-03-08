package com.ntnu.ivansh.Building.Restful.Api.helloWorld;

public class HelloWorldBean {
    private String message;
    public HelloWorldBean(String helloWorld) {
        message=helloWorld;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
