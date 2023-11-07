package org.example.employees;
import jakarta.transaction.Transactional;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceEmployee {

    @Autowired
    private static EmployeeRepository employeeRepository;

    @Transactional
    public static Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public static Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public static List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public static Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId);

        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setTitle(updatedEmployee.getTitle());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setManager(updatedEmployee.getManager());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    @Transactional
    public static void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public static List<Employee> findEmployeesBySalaryRange(double minSalary, double maxSalary) {
        return employeeRepository.findEmployeesInSalaryRange(minSalary, maxSalary);
    }

    public static List<Employee> findAverageSalaryByDepartment() {
        return employeeRepository.findAverageSalaryByDepartment();
    }
}


