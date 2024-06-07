package com.crudpractice.controller;

import com.crudpractice.entity.EmployeeEntity;
import com.crudpractice.exception.ResourceNotFoundException;
import com.crudpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crudpractice/employees")
@RestController
public class EmployeeController {
    /*private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }*/
    @Autowired
    EmployeeService service;

    @PostMapping("/create")
    public EmployeeEntity createEmp(@RequestBody EmployeeEntity employee) {
        return service.createEmp(employee);
    }

    @GetMapping("/all")
    public List<EmployeeEntity> findAllEmployees(){
        return service.findAllEmp();
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<EmployeeEntity> findEmpById(@PathVariable Long empId) {
        EmployeeEntity empById = service.findEmpById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with {}", empId));
        return ResponseEntity.ok(empById);
    }

    @PutMapping("/employee/{empId}")
    public ResponseEntity<EmployeeEntity> updateEmp(@PathVariable Long empId, @RequestBody EmployeeEntity updatedEmpDetails) {
        EmployeeEntity empById = service.findEmpById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with {}", empId));
        empById.setEmpId(empById.getEmpId());
        empById.setEmpName(updatedEmpDetails.getEmpName());
        empById.setMobNo(updatedEmpDetails.getMobNo());

        return ResponseEntity.ok(service.saveUpdatedEmp(empById));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long empId){
        EmployeeEntity empById = service.findEmpById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with {}", empId));
        service.deleteById(empById);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
