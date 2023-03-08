package com.ntnu.ivansh.Building.Restful.Api.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String s) {
        this.name=s;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
