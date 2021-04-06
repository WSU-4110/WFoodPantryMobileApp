package com.example.csc4111project3;

public class User {
    public String firstName, lastName, email, phoneNumber;

    //default constructor
    public User(){}

    //constructor
    public User(String firstName, String lastName, String phoneNumber, String email){
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.phoneNumber    = phoneNumber;
        this.email          = email;
    }
}//end of User Class
