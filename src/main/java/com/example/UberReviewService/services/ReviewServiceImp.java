package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

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
}
