package org.example.repository;

import jdk.dynalink.linker.ConversionComparator;
import org.example.departments.Department;
import org.example.employees.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeRepository {

    private final ConcurrentHashMap<Long, Employee> employees = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(0);

    public List<Employee>findEmployeesInSalaryRange(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary)
    { return new ArrayList<>(employees.values());}

    @Query(nativeQuery = true, value = "SELECT d.name AS department, AVG(e.salary) AS averageSalary " +
            "FROM Employee e " +
            "INNER JOIN Department d ON e.department_id = d.id " +
            "GROUP BY d.name")
    public List<Employee> findAverageSalaryByDepartment() {
        { return new ArrayList<>(employees.values()); }
}
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());}
    public Employee findById(Long id) { return employees.get(id);}

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idGenerator.incrementAndGet());
        }
        employees.put(employee.getId(), employee);
        return employee;
    }
    public void deleteById(Long id) { employees.remove(id);}


}

