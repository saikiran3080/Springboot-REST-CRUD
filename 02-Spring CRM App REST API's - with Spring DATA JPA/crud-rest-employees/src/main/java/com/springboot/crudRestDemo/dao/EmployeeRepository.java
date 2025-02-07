package com.springboot.crudRestDemo.dao;

import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//created Spring DATA JPA Repository : EmployeeRepository
public interface EmployeeRepository extends JpaRepository<Employee ,Integer> {
//    that's it no need to write any implementation like (DAO interface & its implementation)
//    just use in place EmployeeeDao , by EmployeeRepository as Spring Data JPA Repository
}
