package org.example.repository;

import org.example.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDatabaseRepository extends JpaRepository<Employee, Long> {


}
