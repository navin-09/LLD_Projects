package com.navin.bookmyshow.models;

public class SeatType extends BaseModel {

    private String name;

    public boolean equals(SeatType obj) {
        return this.name.equals(obj.name);
    }
}