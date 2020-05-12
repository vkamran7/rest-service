package com.rest.webservices.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public PersonV1() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
