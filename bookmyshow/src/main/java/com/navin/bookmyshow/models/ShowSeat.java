package com.navin.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    Date blockedAt;
    
}
// 1 5 available
// 3 5

// ShowSeat * Show
// 1 : 1
// M  : 1
//Show Seat status
// 1 5 ---
// 1 6 --
// 1 7 --
// 2 5
// 3 5

// 1 ShowSeat object => 1 show * 1 seat
// 1 show => how many showSeat object ? Multiple