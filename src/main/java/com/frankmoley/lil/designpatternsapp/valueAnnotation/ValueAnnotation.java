package com.frankmoley.lil.designpatternsapp.valueAnnotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@ConfigurationProperties(prefix = "filter")
public class ValueAnnotation {

    @Value("${example.value.annotation}")
    private String exampleValue;

    @Value("${example.value.list}")
    private List<String> exampleValueList;


    private List<String> listOfFilters;


    public void printValues() {
        log.info("exampleValue: " + exampleValue);
        log.info("exampleValueList: " + exampleValueList);
        log.info("listOfFilters: " + listOfFilters);
    }

}
