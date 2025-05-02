package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name="bookingReview") // creates a new table with name="bookingReview"
public class Review {

    @Id  // this annotation makes the id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this id property is not going to be filled by user identity means auto incremented
    Long id;

    @Column(nullable=false)
    String content;

    Double rating;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)   // this annotation tells spring about the format of Date object to be stored i.e Date /Time ? Timestamp
    @CreatedDate         // this annotation tells spring that only handle it for object creation
    Date createdAt;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate    // this annotation tells spring that only handle it for object update
    Date updatedAt;




}
