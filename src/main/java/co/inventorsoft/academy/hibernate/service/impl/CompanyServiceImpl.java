package co.inventorsoft.academy.hibernate.service.impl;

import co.inventorsoft.academy.hibernate.dao.CompanyDAO;
import co.inventorsoft.academy.hibernate.exception.DaoException;
import co.inventorsoft.academy.hibernate.exception.ServiceException;
import co.inventorsoft.academy.hibernate.model.Company;
import co.inventorsoft.academy.hibernate.service.CompanyService;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public void saveCompany(Company company) {
        try {
            companyDAO.save(company);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyDAO.findById(id);
    }

    @Override
    public void updateCompany(Company company) {
        try {
            companyDAO.update(company);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCompany(Long id) {
        try {
            Optional<Company> company = companyDAO.findById(id);
            if (company.isPresent()) {
                companyDAO.delete(company.get());
            } else {
                throw new IllegalArgumentException("Company with id " + id + " not found!");
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
