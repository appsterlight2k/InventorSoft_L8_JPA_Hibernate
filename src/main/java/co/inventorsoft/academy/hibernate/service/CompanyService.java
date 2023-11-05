package co.inventorsoft.academy.hibernate.service;

import co.inventorsoft.academy.hibernate.model.Company;

public interface CompanyService {
    void saveCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Company company);
    void deleteCompany(Long id);
}
