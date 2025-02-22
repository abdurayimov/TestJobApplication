package tech.edex.jobapp.review.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.edex.jobapp.review.model.Review;
import tech.edex.jobapp.review.service.ReviewService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(@PathVariable Long companyId) {
        return ResponseEntity.ok(reviewService.findAll(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Long companyId,
                                               @RequestBody Review review) {
        boolean isReviewSaved = reviewService.createReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long id) {
        Review reviewById = reviewService.getReviewById(companyId, id);
        if (reviewById != null) {
            return ResponseEntity.ok(reviewById);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long id) {
        boolean deleted = reviewService.deleteReview(companyId, id);;
        if (deleted) {
            return new ResponseEntity<>("Review deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long id,
                                               @RequestBody Review updatedReview) {
        boolean updated = reviewService.updateReview(companyId, id, updatedReview);
        if (updated) {
            return new ResponseEntity<>("Review updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }
}

