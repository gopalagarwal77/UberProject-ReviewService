package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service


public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;


    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository){
          this.reviewRepository=reviewRepository;
          this.bookingRepository=bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************");
//       Review r = Review.builder()
//               .content("Amazing ride quality")
//
//               .rating(5.0)
//               .build();  // code to create plain java object
//
//        Booking b = Booking.builder()
//                .review(r)
//                        .endTime(new Date())
//                                .build();
//
//        bookingRepository.save(b);   // we should create a review first and then booking because booking  depended on review
//        reviewRepository.save(r);

      Optional<Booking> b = bookingRepository.findById(2L);

      if(b.isPresent()){
          System.out.println(b.get());
          bookingRepository.delete(b.get());
     }
    }
}
