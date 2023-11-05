package co.inventorsoft.academy.hibernate.service.impl;

import co.inventorsoft.academy.hibernate.dao.EmployeeDAO;
import co.inventorsoft.academy.hibernate.model.Employee;
import co.inventorsoft.academy.hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }
}
