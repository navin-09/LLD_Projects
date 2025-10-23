package com.navin.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    private int price;
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;

}
// SHOW SeatType price
// 1 Gold --
// 2 Gold ---
// 1 Platinum --
// 1 Silver