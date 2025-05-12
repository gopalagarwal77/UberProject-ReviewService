package com.example.UberReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends  BaseModel{

    private String Name;

    @Column(nullable = false , unique = true)

    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private ArrayList<Booking> bookings = new ArrayList<>();


}
