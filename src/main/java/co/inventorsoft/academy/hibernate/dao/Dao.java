package co.inventorsoft.academy.hibernate.dao;

import co.inventorsoft.academy.hibernate.exception.DaoException;
import java.util.Optional;

public interface Dao<T> {
    void save(T t) throws DaoException;
    Optional<T> findById(Long id);
    void update(T t) throws DaoException;
    void delete(Long id) throws DaoException;
    void delete(T t) throws DaoException;
}
