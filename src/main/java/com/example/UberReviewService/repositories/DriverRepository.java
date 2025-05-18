package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
   Optional<Driver> findByIdAndLicenseNumber(long id , String licenseNumber);

   // raw mysql query
   @Query(nativeQuery = true, value="SELECT * FROM DRIVER WHERE ID=:id AND license_number =:licenseNumber") // error is thrown at runtime if query has issue
   Optional<Driver> rawfindByIdAndLicenseNumber(long id , String licenseNumber);

   // Hibernate query
  @Query("select d from Driver as d where d.id =:id and d.licenseNumber =:licenseNumber")
 //  Optional<Driver> hqlfindByIdAndLicense(long id , String licenseNumber); // error is thrown at compile time
   Optional<Driver>   hqlfindByIdAndLicenseNumber(Long id, String licenseNumber);



}
