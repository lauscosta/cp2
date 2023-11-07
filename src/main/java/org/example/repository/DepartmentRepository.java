package org.example.repository;

import org.example.departments.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DepartmentRepository {

    private final ConcurrentHashMap<Long, Department> departamentos = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Department> departmentConcurrentHashMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public Department findByName(String name) { return departmentConcurrentHashMap.get(name);}
    public List<Department> findAll() {
        return new ArrayList<>(departamentos.values());
    }
    public Department findById(Long id) { return departamentos.get(id);}
    public Department save(Department department) {
        if (department.getId() == null) {
            department.setId(idGenerator.incrementAndGet());
        }
        departamentos.put(department.getId(), department);
        return department;
    }

    public void deleteById(Long id) { departamentos.remove(id);}


}
