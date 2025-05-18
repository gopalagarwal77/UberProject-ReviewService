package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service


public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;


    public ReviewService(ReviewRepository reviewRepository , BookingRepository bookingRepository, DriverRepository driverRepository){
          this.reviewRepository=reviewRepository;
          this.bookingRepository=bookingRepository;
          this.driverRepository= driverRepository;
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

//      Optional<Booking> b = bookingRepository.findById(2L);
//
//      if(b.isPresent()){
//          System.out.println(b.get());
//          bookingRepository.delete(b.get());
//     }
       // Optional<Driver> driver = driverRepository.findByIdAndLicenseNumber(1L,"DL121212");
//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//
////            List<Booking> bookings =bookingRepository.findByDriverId(1L);
////            for(Booking booking : bookings){
////                System.out.print(booking.getBookingStatus());
////            }
//            List<Booking> bookings = driver.get().getBookings();
//            for(Booking booking:bookings){
//                System.out.println(booking.getId());
//            }
//
//        }
//           Optional<Driver> d = driverRepository.rawfindByIdAndLicenseNumber(1L,"DL121212");
//            System.out.print(d.get().getName());
        Optional<Driver> d = driverRepository.hqlfindByIdAndLicenseNumber(1L,"DL121212");
        System.out.print(d.get().getName());

    }
}
