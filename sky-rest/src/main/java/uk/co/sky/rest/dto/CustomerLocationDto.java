package uk.co.sky.rest.dto;

import java.io.Serializable;

public class CustomerLocationDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private String location;

    public CustomerLocationDto(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}