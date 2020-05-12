package com.rest.webservices.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public PersonV2() {

    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
