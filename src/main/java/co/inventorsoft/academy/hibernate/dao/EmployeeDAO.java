package co.inventorsoft.academy.hibernate.dao;

import co.inventorsoft.academy.hibernate.model.Employee;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    Employee findById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
