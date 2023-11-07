package org.example.departments;

import org.example.repository.DepartmentDatabaseRepository;
import org.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class ControllerDepartment{
    @Autowired
    private ServiceDepartment serviceDepartment;

    @PostMapping
    public Department createDepartment(@RequestParam String name) {
        return serviceDepartment.createDepartment(name);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return serviceDepartment.getDepartmentById(id);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return serviceDepartment.getAllDepartments();
    }

    @GetMapping("/{name}")
    public Department getDepartmentByName(@PathVariable String name){
        return serviceDepartment.getDepartmentByName(name);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestParam String name) {
        return serviceDepartment.updateDepartment(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        serviceDepartment.deleteDepartment(id);
    }
}

