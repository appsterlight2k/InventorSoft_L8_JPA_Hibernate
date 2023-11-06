package co.inventorsoft.academy.hibernate.service;

import co.inventorsoft.academy.hibernate.exception.ServiceException;
import co.inventorsoft.academy.hibernate.model.Employee;
import java.util.Optional;

public interface EmployeeService {
    void saveEmployee(Employee employee) throws ServiceException;
    Optional<Employee> getEmployeeById(Long id);
    void updateEmployee(Employee employee) throws ServiceException;
    void deleteEmployee(Employee employee) throws ServiceException;
}
