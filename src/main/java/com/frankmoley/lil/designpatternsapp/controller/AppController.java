package com.frankmoley.lil.designpatternsapp.controller;


import com.frankmoley.lil.designpatternsapp.builder.Contact;
import com.frankmoley.lil.designpatternsapp.builder.ContactBuilder;
import com.frankmoley.lil.designpatternsapp.factory.Pet;
import com.frankmoley.lil.designpatternsapp.factory.PetFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    @Autowired
    public PetFactory petFactory;

    @GetMapping
    public String getDefault() {
        return "{\"message\": \"Hello World\"}";
    }


    @PostMapping("adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        Pet createdPet = this.petFactory.createPet(type);
        createdPet.setName(name);
        createdPet.feed();
        return createdPet;
    }

    @GetMapping("getContact")
    public List<Contact> getContact() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new ContactBuilder().setFirstName("Barotsz").setLastName("Abramowicz").build());
        return contacts;
    }
}
