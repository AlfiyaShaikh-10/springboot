package com.example.test.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/employees")
public class MyRestController {
    
    @GetMapping("/hello")
    public String requestMethodName() {
        return new String("hello");
    }
    List<Employee> employees = new ArrayList<>();
    
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        // employees.add(null);
        return employees;
    }
@PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                emp.setName(updatedEmp.getName());
                emp.setEmail(updatedEmp.getEmail());
                return "Employee updated!";
            }
        }
        return "Employee not found!";
    }
    

    @PostMapping("/")
    public String postMethodName(@RequestBody Employee entity) {
        employees.add(entity);
        return "added";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean removed = employees.removeIf(emp -> emp.getId().equals(id));
        if (removed)
            return "Employee deleted!";
        else
            return "Employee not found!";
    }
    
}
