package tech.edex.jobapp.job.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.edex.jobapp.company.model.Company;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String minSalary;

    private String maxSalary;

    private String location;

    @ManyToOne
    private Company company;
}
