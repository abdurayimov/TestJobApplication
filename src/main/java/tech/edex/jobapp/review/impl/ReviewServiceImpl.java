package tech.edex.jobapp.review.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.edex.jobapp.company.impl.CompanyServiceImpl;
import tech.edex.jobapp.company.model.Company;
import tech.edex.jobapp.company.service.CompanyService;
import tech.edex.jobapp.review.model.Review;
import tech.edex.jobapp.review.repository.ReviewRepository;
import tech.edex.jobapp.review.service.ReviewService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    @Override
    public List<Review> findAll(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteReview(Long companyId, Long id) {
        if ((companyService.getCompanyById(companyId) != null)
                && (reviewRepository.existsById(id))) {
            Review review = reviewRepository.findById(id).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long id, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(id);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }
}
