package org.example.employees;

import jakarta.persistence.*;
import org.example.departments.Department;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private double salary;

    private String manager;

    private Department department;

    public Employee(Long id, String name, String title, double salary) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.salary = salary;


    }

    public Long getId(){ return id; }
    public void setId(Long id) {this.id = id; }

    public String getName(){ return name; }
    public void setName(String name) {this.name = name; }

    public String getTitle(){ return title; }
    public void setTitle(String title) {this.title = title; }

    public String getManager(){ return manager; }
    public void setManager(String manager){this.manager = manager;}

    public double getSalary(){return salary; }
    public void setSalary(double salary){this.salary = salary; }

}


