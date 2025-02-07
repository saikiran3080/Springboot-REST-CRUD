package com.springboot.crudRestDemo.dao;

import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//created Spring DATA JPA Repository : EmployeeRepository
//@RepositoryRestResource(path = "crmemployees") : can able to change endpoints name also
public interface EmployeeRepository extends JpaRepository<Employee ,Integer> {
//    that's it no need to write any implementation like (DAO interface & its implementation)
//    just use in place EmployeeeDao , by EmployeeRepository as Spring Data JPA Repository
}
