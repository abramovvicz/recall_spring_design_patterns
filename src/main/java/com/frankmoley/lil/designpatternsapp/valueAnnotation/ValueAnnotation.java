package com.frankmoley.lil.designpatternsapp.valueAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "filter")
public class ValueAnnotation {

    @Value("${example.value.annotation}")
    private String exampleValue;

    @Value("${example.value.list}")
    private List<String> exampleValueList;


    private List<String> listOfFilters;

   



    public void printValues(){
        System.out.println("exampleValue: " + exampleValue);
        System.out.println("exampleValueList: " + exampleValueList);

        System.out.println(listOfFilters);
    }

}
