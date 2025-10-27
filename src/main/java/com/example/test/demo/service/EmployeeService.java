package com.example.test.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.demo.model.Employee;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        System.out.println("EmployeeService bean created ✅");
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Added: " + employee.getName() + ", Total employees: " + employees.size());
    }

    public boolean updateEmployee(long id, Employee updatedVal) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                e.setName(updatedVal.getName());
                e.setEmail(updatedVal.getEmail());
                System.out.println("updated" + e.toString());
            }
            return true;
        }
        return false;
    }

    public boolean deleteEmloyee(long id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }

}
