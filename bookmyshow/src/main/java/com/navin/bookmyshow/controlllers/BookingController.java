package com.navin.bookmyshow.controlllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.navin.bookmyshow.dtos.BookMovieRequestDTO;
import com.navin.bookmyshow.dtos.BookMovieResponseDTO;
import com.navin.bookmyshow.dtos.ResponseStatus;
import com.navin.bookmyshow.models.Booking;
import com.navin.bookmyshow.services.BookingService;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDTO bookTicket(BookMovieRequestDTO bookMovieRequestDTO) {
        BookMovieResponseDTO response = new BookMovieResponseDTO();
        try {
            Booking booking = bookingService.bookTicket(
                    bookMovieRequestDTO.getShowSeatIds(),
                    bookMovieRequestDTO.getShowId(),
                    bookMovieRequestDTO.getUserId());
            // response.setResponseStatus(ResponseStatus.SUCCESS).setBookingId()
            response.setBookingId(booking.getId())
                    .setAmount(booking.getAmount())
                    .setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

}
