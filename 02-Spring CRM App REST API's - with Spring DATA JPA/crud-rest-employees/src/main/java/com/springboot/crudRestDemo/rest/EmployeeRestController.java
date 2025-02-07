package com.springboot.crudRestDemo.rest;

import com.springboot.crudRestDemo.entity.Employee;
import com.springboot.crudRestDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

//    quick and dirty : inject employee dao (use constructor injection )
//    public EmployeeRestController(EmployeeDAO theEmployeeDao)
//    {
//        employeeDAO = theEmployeeDao;
//    }

    @Autowired
      public EmployeeRestController(EmployeeService  theEmployeeService)
      {
          employeeService = theEmployeeService;
      }

//    expose '/employees' , return list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployee()
    {
        return  employeeService.findAll();
    }

//    add mapping for GET employees/{employeeid}
//    by default  @GetMapping-id & @PathVaraible id must be same
    @GetMapping("/employees/{id}")
    public Employee getSingleEmployee(@PathVariable int id)
    {
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee==null)
        {
            throw new RuntimeException("Employee id not found: "+id);
        }

        return theEmployee;
    }

//    add mapping for POST- /employees - add new employee
    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody  Employee theEmployee)
    {
//        by default set id =0 , to insert rather than update
        theEmployee.setId(0);
        Employee dbEmployee  = employeeService.save(theEmployee);

        return dbEmployee;
    }

//    add mapping for PUT /employee : updating existing employee
@PutMapping("/employees")
public Employee updateEmployee(@RequestBody  Employee theEmployee)
{
    Employee dbEmployee  = employeeService.save(theEmployee);

    return dbEmployee;
}

//add mapping for DELETE  /employees/{employeeId} : for deleting employee
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee tempEmployee  = employeeService.findById(id);

        if(tempEmployee==null)
        {
            throw new RuntimeException("Employee not found id: "+id);
        }

        employeeService.deleteById(id);

        return  "deleted Employee id: "+id;
    }


}
