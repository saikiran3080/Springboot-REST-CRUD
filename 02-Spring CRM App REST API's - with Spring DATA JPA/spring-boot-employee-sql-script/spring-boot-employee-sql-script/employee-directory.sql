package com.springboot.crudRestDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
//    define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

//    define constructor
    public Employee()
    {

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //    define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    define toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}




dao

package com.springboot.crudRestDemo.dao;

import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//created Spring DATA JPA Repository : EmployeeRepository
public interface EmployeeRepository extends JpaRepository<Employee ,Integer> {
//    that's it no need to write any implementation like (DAO interface & its implementation)
//    just use in place EmployeeeDao , by EmployeeRepository as Spring Data JPA Repository
}


service
package com.springboot.crudRestDemo.service;

import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}

package com.springboot.crudRestDemo.service;

import com.springboot.crudRestDemo.dao.EmployeeRepository;
import com.springboot.crudRestDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepositry)
    {
        employeeRepository = theEmployeeRepositry;
    }

    @Override
    public List<Employee> findAll() {
//        delegates the call to DAO

        return employeeRepository.findAll();
    }

    @Override
//    Optional : is a different pattern instead of checking for null
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee= null;

        if(result.isPresent())
        {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Couldn't find Employee id: "+theId);
        }

        return theEmployee;
    }

//    @Transactional
    @Override
    public Employee save(Employee theEmployees) {
        return employeeRepository.save(theEmployees);
    }

//    @Transactional : can remove Spring DATA JPA handles transaction

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}



mvccontroller

package com.springboot.crudRestDemo.mvccontroller;


import com.springboot.crudRestDemo.entity.Employee;
import com.springboot.crudRestDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //    Although since only one constructor @Autowired is optional
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService = theEmployeeService;
    }

//  Add mapping for  "/list"
    @GetMapping("/list")
    public String employeesList(Model theModel)
    {
//        get list of employees from db
        List<Employee> theEmployees = employeeService.findAll();

//        add to the spring model
        theModel.addAttribute("employees" , theEmployees);

        return "list-employees";
    }
}



spring.application.name=crud-rest-employees
#JDBC properties
spring.datasource.url = jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username = springstudent
spring.datasource.password = springstudent
logging.level.org.springframework.web=DEBUG
#spring.thymeleaf.prefix=classpath:/templates/
#spring.thymeleaf.suffix=.html

I have completed my MCA. This job matches more with my technical skills and knowledge, and I am also interested in this job role. Therefore, I want to pursue this job.

