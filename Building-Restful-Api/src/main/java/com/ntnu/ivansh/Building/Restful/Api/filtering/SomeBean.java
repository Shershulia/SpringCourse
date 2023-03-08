package com.ntnu.ivansh.Building.Restful.Api.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("field1")
@JsonFilter("SomebeanFilter")
public class SomeBean {
    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;
    public SomeBean(String s, String s1, String s2) {
        this.field1=s;
        this.field2=s1;
        this.field3=s2;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
