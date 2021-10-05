package com.frankmoley.lil.designpatternsapp.builder;

public class ContactBuilder {

    private String lastName;
    private String firstName;
    private String emailAddress;


    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }


    public Contact build(){
        return new Contact(firstName, lastName, emailAddress);
    }
}
