package co.inventorsoft.academy.hibernate.service;

import co.inventorsoft.academy.hibernate.model.Employee;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
