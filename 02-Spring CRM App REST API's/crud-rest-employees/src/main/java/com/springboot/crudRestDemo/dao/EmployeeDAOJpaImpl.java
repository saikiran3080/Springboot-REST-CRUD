package com.springboot.crudRestDemo.dao;

import com.springboot.crudRestDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository is used in Spring to define a DAO component,
// enabling automatic bean registration and exception translation for data access operations.
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
//    define field for entity manager
    private EntityManager entityManager;

//    set up constructor injection
//    spring boot will automatically create the entity manager : we jst need to inject using autowire
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
//        create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);

//        execute a query and get result
        List<Employee> employees = theQuery.getResultList();

//        return result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
//        get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

//        return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
//        save Employee
//        if id==0 the insert/save else update
        Employee dbEmployee  =  entityManager.merge(theEmployee);
//        return dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
//        find employee by Id
        Employee theEmployee = entityManager.find(Employee.class , theId);

//        remove employee
        entityManager.remove(theEmployee);

    }
}
