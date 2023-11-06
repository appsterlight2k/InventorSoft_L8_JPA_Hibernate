package co.inventorsoft.academy.hibernate;

import co.inventorsoft.academy.hibernate.dao.CompanyDAO;
import co.inventorsoft.academy.hibernate.dao.EmployeeDAO;
import co.inventorsoft.academy.hibernate.dao.impl.CompanyDAOImpl;
import co.inventorsoft.academy.hibernate.dao.impl.EmployeeDAOImpl;
import co.inventorsoft.academy.hibernate.model.Company;
import co.inventorsoft.academy.hibernate.model.Employee;
import co.inventorsoft.academy.hibernate.service.CompanyService;
import co.inventorsoft.academy.hibernate.service.EmployeeService;
import co.inventorsoft.academy.hibernate.service.impl.CompanyServiceImpl;
import co.inventorsoft.academy.hibernate.service.impl.EmployeeServiceImpl;
import co.inventorsoft.academy.hibernate.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        // Setting up EntityManagerFactory and EntityManager
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        // Initializing DAO implementations
        CompanyDAO companyDAO = new CompanyDAOImpl(em);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(em);

        // Initializing service classes
        CompanyService companyService = new CompanyServiceImpl(companyDAO);
        EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);

        // Creating a new company
        Company toyotaCompany = generateCompany();

        // Saving the company in the database
        companyService.saveCompany(toyotaCompany);

        // Retrieving the company by id
        Optional<Company> companyOpt = companyService.getCompanyById(toyotaCompany.getId());
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            System.out.println("Company Retrieved from DB: " + company.getCompanyName());

            // Updating company information
            company.setPhone("1-123-45678");
            companyService.updateCompany(company);

            // Creating a new employee
            Employee obiOne = generateEmployee(company);

            // Saving the employee in the DB
            employeeService.saveEmployee(obiOne);

            // Retrieving the employee by id
            Optional<Employee> employeeOpt = employeeService.getEmployeeById(obiOne.getId());
            if (employeeOpt.isPresent()) {
                Employee employee = employeeOpt.get();
                System.out.printf("Employee retrieved from DB: %s %s%n", employee.getFirstname(), employee.getLastname());

                // Updating employee information
                employee.setEmail("jedi.obi.one@gmail.com");
                employeeService.updateEmployee(employee);
            }

            // Deleting the employee
            employeeService.deleteEmployee(obiOne);

            // Deleting the company
            companyService.deleteCompany(company.getId());
        }
        // Closing EntityManager and EntityManagerFactory
        em.close();
        JpaUtil.close();
    }

    private static Company generateCompany() {
        Company company = new Company();
        company.setCompanyName("Toyota");
        company.setPhone("(0565) 28-2121");
        company.setAddress("1 Toyota-Cho");
        company.setCity("Toyota City");
        company.setRegion("Aichi Prefecture");
        company.setZip("471-8571");
        company.setCountry("Japan");

        return company;
    }

    private static Employee generateEmployee(Company company) {
        Employee employee = new Employee();
        employee.setFirstname("Obi-Wan");
        employee.setLastname("Kenobi");
        employee.setPhone("+1-354-543-3453");
        employee.setEmail("obi.one@mail.com");
        employee.setCompany(company);

        return employee;
    }
}
