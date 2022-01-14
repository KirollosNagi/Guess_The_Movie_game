package com.company;

public class Contact {
    String name;
    String email;
    String phoneNumber;
    Contact(){};
    Contact(String name, String email, String phoneNumber)
    {
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + " email="+email +" phone="+phoneNumber + "]";
    }
}
