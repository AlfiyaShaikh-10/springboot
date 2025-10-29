package com.example.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.demo.entity.EmployeeEntity;
import com.example.test.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
