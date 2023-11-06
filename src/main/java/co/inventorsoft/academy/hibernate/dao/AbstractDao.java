package co.inventorsoft.academy.hibernate.dao;

import co.inventorsoft.academy.hibernate.exception.DaoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {
    private final Class<T> entityClass;
    private final EntityManager entityManager;

    protected AbstractDao(Class<T> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @Override
    public void save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(String.format("Error while saving %s entity!", entityClass.getSimpleName()), e);
        }
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public void update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(String.format("Error while updating %s entity!", entityClass.getSimpleName()), e);
        }
    }

    @Override
    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (entityManager.contains(entity)) {
                entityManager.remove(entity);
            } else {
                entityManager.remove(entityManager.merge(entity));
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new DaoException(String.format("Error while deleting %s entity!", entityClass.getSimpleName()), e);
        }
    }

    @Override
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        Optional<T> entityOptional = findById(id);
        if (entityOptional.isPresent()) {
            T entity = entityOptional.get();
            try {
                transaction.begin();
                if (entityManager.contains(entity)) {
                    entityManager.remove(entity);
                } else {
                    entityManager.remove(entityManager.merge(entity));
                }
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw new DaoException(String.format("Error while deleting %s entity with id %s!", entityClass.getSimpleName(), id), e);
            }
        }
    }
}
