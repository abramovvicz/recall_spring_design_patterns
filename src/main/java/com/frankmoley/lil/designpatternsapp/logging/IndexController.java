package com.frankmoley.lil.designpatternsapp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/")
    String index(){
        System.out.println("dupa");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new SpringLoggingHelper().helpMethod();
        return "index";
    }
}
