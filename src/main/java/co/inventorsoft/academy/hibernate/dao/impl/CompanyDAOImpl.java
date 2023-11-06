package co.inventorsoft.academy.hibernate.dao.impl;

import co.inventorsoft.academy.hibernate.dao.AbstractDao;
import co.inventorsoft.academy.hibernate.dao.CompanyDAO;
import co.inventorsoft.academy.hibernate.model.Company;
import jakarta.persistence.EntityManager;

public class CompanyDAOImpl extends AbstractDao<Company> implements CompanyDAO {
    public CompanyDAOImpl(EntityManager entityManager) {
        super(Company.class, entityManager);
    }
}
