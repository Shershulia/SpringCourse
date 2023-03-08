package com.ntnu.lernspringframework.example.a2;

import org.springframework.stereotype.Component;

@Component

public class MySqlDb implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[] {1,2,3,4,5};
    }
}
