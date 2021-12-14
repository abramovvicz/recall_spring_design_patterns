package com.frankmoley.lil.designpatternsapp.valueAnnotation;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ValueAnnotation {

    @Value("${example.value.annotation}")
    private String exampleValue;

    @Value("${example.value.annotation.list}")
    private List<String> exampleValueList;

   



    public void printValues(){
        System.out.println("exampleValue: " + exampleValue);
        System.out.println("exampleValueList: " + exampleValueList);
    }

}
