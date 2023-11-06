package co.inventorsoft.academy.hibernate.service;

import co.inventorsoft.academy.hibernate.exception.ServiceException;
import co.inventorsoft.academy.hibernate.model.Company;
import java.util.Optional;

public interface CompanyService {
    void saveCompany(Company company) throws ServiceException;
    Optional<Company> getCompanyById(Long id);
    void updateCompany(Company company) throws ServiceException;
    void deleteCompany(Long id) throws ServiceException;
}
