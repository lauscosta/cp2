package org.example.departments;

import org.example.repository.DepartmentDatabaseRepository;
import org.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class ControlarDepartamentos{
    @Autowired
    private ServiceDepartment servicoDepartamento;

    @PostMapping
    public Department criarDepartamento(@RequestParam String name) {
        return serviceDepartment.criarDepartamento(name);
    }

    @GetMapping("/{id}")
    public Department receberDepartamentoId(@PathVariable Long id) {
        return serviceDepartment.receberDepartamentoId(id);
    }

    @GetMapping
    public List<Department> receberTodosDepartamentos() {
        return serviceDepartment.receberTodosDepartamentos();
    }

    @GetMapping("/{name}")
    public Department receberDepartamentoPorNome(@PathVariable String name){
        return serviceDepartment.receberDepartamentoPorNome(name);
    }

    @PutMapping("/{id}")
    public Department atualizarDepartmento(@PathVariable Long id, @RequestParam String name) {
        return serviceDepartment.atualizarDepartmento(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletarDepartmento(@PathVariable Long id) {
        serviceDepartment.deletarDepartmento(id);
    }
}

