package com.navin.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BookMovieResponseDTO {
    private ResponseStatus responseStatus;
    private Long bookingId;
    private int amount;

}
