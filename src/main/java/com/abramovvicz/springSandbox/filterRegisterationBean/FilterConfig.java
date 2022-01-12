package com.abramovvicz.springSandbox.filterRegisterationBean;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FilterConfig {



    @Bean
    FilterRegistrationBean<RequestResponseFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<RequestResponseFilter> filterFilterRegistration = new FilterRegistrationBean<>();
        filterFilterRegistration.setFilter(new RequestResponseFilter());
        filterFilterRegistration.addUrlPatterns("/users/*");
        filterFilterRegistration.setOrder(2);
        return filterFilterRegistration;
    }

}
