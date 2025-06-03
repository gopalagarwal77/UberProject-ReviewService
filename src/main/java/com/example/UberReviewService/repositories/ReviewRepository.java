package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Passenger;
import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

// responsibility of the repository layer is to communicate with the database and execute queries
// spring data jpa says that you can execute raw queries hibernate like queries or I will give you some methods automatically you just have to do one simple thing and you can get access to all those methods and those methods actually create that object
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

    Integer countAllByRatingLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("select r from Booking b inner join Review r where b.id= :bookingId")
    Review findByBookingId(long bookingId);

//    @Query("select new com.example.UberReviewService.repositories() from Booking b inner join Passenger p inner join Driver d")
//    custom findDriverPassengerReviewByBookingId(long bookingId);

}

class custom{
    public Review review;
    public Driver driver;
    public Passenger passenger;

    public custom(Review review,Passenger passenger,Driver driver){
        this.driver=driver;
        this.passenger=passenger;
        this.review=review;
    }

}
