package com.example.UberReviewService.adapters;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public  class CreateReviewDtoToReviewAdapterImp implements CreateReviewDtoToReview{


    private BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapterImp(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }
    @Override
    public Review convertDto(CreateReviewDto createReviewDto){
        Optional<Booking> booking = bookingRepository.findById(createReviewDto.getBookingId());
        if(booking.isEmpty()) return null;
        Review review = Review.builder()
                .rating(createReviewDto.getRating())
                .content(createReviewDto.getContent())
                //.booking(booking.get())
                .build();
        return review;
    }
}
