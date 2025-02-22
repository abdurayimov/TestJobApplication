package tech.edex.jobapp.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edex.jobapp.review.model.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);
}
