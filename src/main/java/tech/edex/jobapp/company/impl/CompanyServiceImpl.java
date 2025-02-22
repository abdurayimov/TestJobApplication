package tech.edex.jobapp.company.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.edex.jobapp.company.model.Company;
import tech.edex.jobapp.company.repository.CompanyRepository;
import tech.edex.jobapp.company.service.CompanyService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> jobOptional = companyRepository.findById(id);
        if (jobOptional.isPresent()) {
            Company updatedCompany = jobOptional.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setJobs(company.getJobs());
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }
}
