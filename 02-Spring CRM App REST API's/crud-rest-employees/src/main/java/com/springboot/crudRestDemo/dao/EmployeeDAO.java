package com.springboot.crudRestDemo.dao;

import com.springboot.crudRestDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployees);
    void deleteById(int theId);

}
