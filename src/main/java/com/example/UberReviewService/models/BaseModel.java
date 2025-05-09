package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public  abstract class BaseModel {  // because we do not want to make object

    @Id  // this annotation makes the id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this id property is not going to be filled by user identity means auto incremented
    protected Long id;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)   // this annotation tells spring about the format of Date object to be stored i.e Date /Time ? Timestamp
    @CreatedDate         // this annotation tells spring that only handle it for object creation
    protected Date createdAt;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate    // this annotation tells spring that only handle it for object update
    protected Date updatedAt;


}
