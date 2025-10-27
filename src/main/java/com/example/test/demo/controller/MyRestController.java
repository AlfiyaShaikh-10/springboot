package com.example.test.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.model.Employee;
import com.example.test.demo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/employees")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        if(employeeService.updateEmployee(id, updatedEmp)){    
            return "Employee updated!";
        }
        return "Employee not found!";
    }

    @PostMapping("/")
    public String postMethodName(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "added";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean removed = employeeService.deleteEmloyee(id);
        if (removed)
            return "Employee deleted!";
        else
            return "Employee not found!";
    }

}
