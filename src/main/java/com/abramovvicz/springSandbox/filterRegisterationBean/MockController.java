package com.abramovvicz.springSandbox.filterRegisterationBean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class MockController {


    @GetMapping("")
    public List<String> getAllUsers() {
        log.info("Fetching all the users");
        return List.of("user1", "user2");
    }
}
