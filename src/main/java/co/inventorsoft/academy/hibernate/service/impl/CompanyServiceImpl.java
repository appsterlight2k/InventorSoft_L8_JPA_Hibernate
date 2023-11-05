package co.inventorsoft.academy.hibernate.service.impl;

import co.inventorsoft.academy.hibernate.dao.CompanyDAO;
import co.inventorsoft.academy.hibernate.model.Company;
import co.inventorsoft.academy.hibernate.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public void saveCompany(Company company) {
        companyDAO.saveCompany(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyDAO.findById(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyDAO.findById(id);
        if (company != null) {
            companyDAO.deleteCompany(company);
        } else {
            throw new IllegalArgumentException("Company with id " + id + " not found!");
        }

    }
}
