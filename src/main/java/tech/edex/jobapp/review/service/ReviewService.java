package tech.edex.jobapp.review.service;

import tech.edex.jobapp.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll(Long companyId);

    boolean createReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long id);

    boolean deleteReview(Long companyId, Long id);

    boolean updateReview(Long companyId, Long id, Review updatedReview);
}
