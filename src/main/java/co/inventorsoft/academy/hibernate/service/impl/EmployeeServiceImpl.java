package co.inventorsoft.academy.hibernate.service.impl;

import co.inventorsoft.academy.hibernate.dao.EmployeeDAO;
import co.inventorsoft.academy.hibernate.exception.DaoException;
import co.inventorsoft.academy.hibernate.exception.ServiceException;
import co.inventorsoft.academy.hibernate.model.Employee;
import co.inventorsoft.academy.hibernate.service.EmployeeService;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void saveEmployee(Employee employee) {
        try {
            employeeDAO.save(employee);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            employeeDAO.update(employee);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try {
            employeeDAO.delete(employee);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
