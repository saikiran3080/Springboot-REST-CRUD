package com.springboot.crudRestDemo.service;

import com.springboot.crudRestDemo.dao.EmployeeDAO;
import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
    {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
//        delegates the call to DAO

        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployees) {
        return employeeDAO.save(theEmployees);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
      employeeDAO.deleteById(theId);
    }
}
