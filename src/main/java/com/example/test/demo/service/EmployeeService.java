package com.example.test.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.demo.entity.EmployeeEntity;
import com.example.test.demo.model.Employee;
import com.example.test.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    // private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public EmployeeEntity updateEmployee(long id, Employee updatedVal) {
        EmployeeEntity existing = employeeRepository.findById(id).orElseThrow();
        existing.setName(updatedVal.getName());
        existing.setEmail(updatedVal.getEmail());
        return employeeRepository.save(existing);
    }

    public void deleteEmloyee(long id) {
        employeeRepository.deleteById(id);
    }

}
