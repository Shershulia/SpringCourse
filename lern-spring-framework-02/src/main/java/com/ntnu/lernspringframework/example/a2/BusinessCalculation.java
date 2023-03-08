package com.ntnu.lernspringframework.example.a2;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class BusinessCalculation {
    private DataService dataService;

    public BusinessCalculation(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
