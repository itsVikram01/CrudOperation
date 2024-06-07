package com.crud.controller;

import com.crud.exception.ResourceNotFoundException;
import com.crud.model.Employee;
import com.crud.repository.EmployeeRepo;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    // create
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    // getAll
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    //getById
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id {}", id) );
        return ResponseEntity.ok(employee);
    }

    //update
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with {}", id) );
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepo.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id {}", id) );
        employeeRepo.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // getAllDataInPaging
    @GetMapping("/allPagingData")
    public ResponseEntity<Page<Employee>> getAllDataInPaging(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<Employee> items = employeeService.getAllDataInPaging(pageNo, pageSize);
        return ResponseEntity.ok(items);
    }

}
