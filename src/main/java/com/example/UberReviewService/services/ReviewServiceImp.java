package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImp implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImp(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }


    @Override
    public Optional<Review> findReviewById(long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public Review publishReview(Review review){
          reviewRepository.save(review);
        return review;
    }

    public Review updateReview(long id ,Review newReviewData){
        Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(newReviewData.getRating()!=null){
            review.setRating(newReviewData.getRating());
        }
        if(newReviewData.getContent() != null){
            review.setContent(newReviewData.getContent());
        }
        return this.reviewRepository.save(review);
    }
}
