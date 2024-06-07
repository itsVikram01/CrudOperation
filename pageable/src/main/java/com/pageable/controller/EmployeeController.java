package com.pageable.controller;

import com.pageable.model.Employee;
import com.pageable.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pageable/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // getAllDataInPaging

    @GetMapping("/allPagingData")
    public ResponseEntity<List<Employee>> getAllDataInPaging(@RequestParam(defaultValue = "1") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize) {
        List<Employee> employees = employeeService.getEmployeesInPaging(pageNo, pageSize);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/allPagingData1")
    public ResponseEntity<Page<Employee>> getAllDataInPaging(Pageable pageable) {
        Page<Employee> employees = employeeService.getAllEmployeesInPaging(pageable);
        return ResponseEntity.ok(employees);
    }

}
