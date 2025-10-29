package com.example.test.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.entity.EmployeeEntity;
import com.example.test.demo.model.Employee;
import com.example.test.demo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp) {
        employeeService.updateEmployee(id, updatedEmp);
    }

    @PostMapping("/")
    public String addEmployee(@RequestBody Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeService.addEmployee(entity);
        return "added";
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
         employeeService.deleteEmloyee(id);
    }

}
