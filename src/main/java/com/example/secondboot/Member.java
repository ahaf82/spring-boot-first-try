package com.example.secondboot;

public class Member {
    private String firstName;
    private String lastName;
    private String city;

    public Member(String firstName, String lastName, String city) {
        this.firstName =firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
