package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="booking_Review") // creates a new table with name="bookingReview"
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends  BaseModel{



    @Column(nullable=false)
    private String content;

    Double rating;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(nullable = false)
    private Booking booking;    // review is a entity so we have to use the OnetoOne annotation
    // we have defined a 1:1 relationship between booking and review


    @Override
    public String toString(){
        return "Review" + " " + this.content + " "+ this.rating +" " +"booking:" + this.booking.getId() + "  " +this.createdAt ;
    }


}
