package com.abramovvicz.springSandbox.hexagonalArchSandbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLoggingHelper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    void helpMethod() {
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
    }


}
