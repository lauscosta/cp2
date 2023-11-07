package org.example.departments;

import org.example.repository.DepartmentDatabaseRepository;
import org.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDepartment {

    @Autowired
    private DepartmentDatabaseRepository departmentDatabaseRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(String name){
        Department newDepartment = new Department();
        newDepartment.setName(name);
        return departmentRepository.save(newDepartment);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    public Department getDepartmentByName(String name){
        return departmentRepository.findByName(name);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long id, String newName) {
        Department departmentToUpdate = departmentRepository.findById(id);
        if (departmentToUpdate != null) {
            departmentToUpdate.setName(newName);
            return departmentRepository.save(departmentToUpdate);
        }
        return null;
    }

    private boolean validDepartment(Department department){
        if(department == null){
            return true;
        }else {
            return false;
        }
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}



