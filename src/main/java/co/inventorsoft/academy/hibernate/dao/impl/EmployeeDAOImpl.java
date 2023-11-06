package co.inventorsoft.academy.hibernate.dao.impl;

import co.inventorsoft.academy.hibernate.dao.AbstractDao;
import co.inventorsoft.academy.hibernate.dao.EmployeeDAO;
import co.inventorsoft.academy.hibernate.model.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeDAOImpl extends AbstractDao<Employee> implements EmployeeDAO {
    public EmployeeDAOImpl(EntityManager entityManager) {
        super(Employee.class, entityManager);
    }
}
