package tech.edex.jobapp.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edex.jobapp.job.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
