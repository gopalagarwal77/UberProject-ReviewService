package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// responsibility of the repository layer is to communicate with the database and execute queries
// spring data jpa says that you can execute raw queries hibernate like queries or I will give you some methods automatically you just have to do one simple thing and you can get access to all those methods and those methods actually create that object
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

}
