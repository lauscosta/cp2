package org.example.employees;


import org.example.departments.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class ControllerEmployee {
    private ServiceEmployee serviceEmployee;
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return ServiceEmployee.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return ServiceEmployee.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return ServiceEmployee.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return ServiceEmployee.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        ServiceEmployee.deleteEmployee(id);
    }

    @GetMapping("/salaryRange")
    public List<Employee> findEmployeesBySalaryRange(
            @RequestParam("minSalary") double minSalary,
            @RequestParam("maxSalary") double maxSalary) {
        return ServiceEmployee.findEmployeesBySalaryRange(minSalary, maxSalary);
    }

    @GetMapping("/averageSalaryByDepartment")
    public List<Employee> findAverageSalaryByDepartment() {
        return ServiceEmployee.findAverageSalaryByDepartment();
    }
}

