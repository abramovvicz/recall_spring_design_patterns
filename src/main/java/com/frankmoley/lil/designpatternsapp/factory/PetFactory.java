package com.frankmoley.lil.designpatternsapp.factory;

import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    public Pet createPet(String petType){
        switch (petType){
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new UnsupportedOperationException("unknown animal type");
        }
    }
}
