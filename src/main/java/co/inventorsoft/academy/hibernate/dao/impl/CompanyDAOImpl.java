package co.inventorsoft.academy.hibernate.dao.impl;

import co.inventorsoft.academy.hibernate.dao.CompanyDAO;
import co.inventorsoft.academy.hibernate.model.Company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CompanyDAOImpl implements CompanyDAO {
    private EntityManager entityManager;

    public CompanyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveCompany(Company company) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(company);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(company);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteCompany(Company company) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (entityManager.contains(company)) {
                entityManager.remove(company);
            } else {
                entityManager.remove(entityManager.merge(company));
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
