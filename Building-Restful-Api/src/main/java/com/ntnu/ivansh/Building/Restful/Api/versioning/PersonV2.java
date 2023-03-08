package com.ntnu.ivansh.Building.Restful.Api.versioning;

public class PersonV2 {
    private String name;
    private String secondName;;
    public PersonV2(String s, String secondName) {
        this.name=s;
        this.secondName=secondName;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
