package org.example.repository;

import org.example.departments.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDatabaseRepository extends JpaRepository<Department, Long> {



}
