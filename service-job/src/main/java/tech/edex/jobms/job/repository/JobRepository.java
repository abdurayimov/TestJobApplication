package tech.edex.jobms.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edex.jobms.job.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
