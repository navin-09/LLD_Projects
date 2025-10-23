package com.navin.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    // 1 : M : One booking will have many showSeats
    // M : 1 : One showSeat can be present in multiple booking -> cancellation
    @ManyToMany
    private List<ShowSeat> showSeats;
    // 1 : 1
    // M : 1
    @ManyToOne
    private User user;
    private Date bookedAt;
    // 1 : 1
    // M : 1
    @ManyToOne
    private Show show;
    private int amount;
    // 1 : M
    // 1 : 1
    @OneToMany
    private List<Payment> payments;

}
