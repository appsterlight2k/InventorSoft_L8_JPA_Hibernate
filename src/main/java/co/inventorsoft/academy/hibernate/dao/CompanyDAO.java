package co.inventorsoft.academy.hibernate.dao;

import co.inventorsoft.academy.hibernate.model.Company;

public interface CompanyDAO {
    void saveCompany(Company company);
    Company findById(Long id);
    void updateCompany(Company company);
    void deleteCompany(Company company);

}
