package com.example.UberReviewService.adapters;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Review;

public interface CreateReviewDtoToReview {

    public Review convertDto(CreateReviewDto createReviewDto);
}
