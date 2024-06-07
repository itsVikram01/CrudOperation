package com.crudwithdao.controller;

import com.crudwithdao.exception.ResourceNotFoundException;
import com.crudwithdao.model.Employee;
import com.crudwithdao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crudwithdao/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // create
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    // getAll
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

    //getById
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.findEmployeeById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id {}", id) );
        return ResponseEntity.ok(employee);
    }

    //update
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee emp = employeeService.findEmployeeById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with {}", id) );
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeService.updateEmployee(emp);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeService.findEmployeeById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id {}", id) );
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // getAllDataInPaging

    /*@GetMapping("/allPagingData")
    public ResponseEntity<List<Employee>> getAllDataInPaging(@RequestParam(defaultValue = "1") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize) {
        List<Employee> employees = employeeService.getEmployeesInPaging(pageNo, pageSize);
        return ResponseEntity.ok(employees);
    }*/
    @GetMapping("/allPagingData")
    public ResponseEntity<Page<Employee>> getAllDataInPaging(Pageable pageable) {
        Page<Employee> employees = employeeService.getAllEmployeesInPaging(pageable);
        return ResponseEntity.ok(employees);
    }

}
