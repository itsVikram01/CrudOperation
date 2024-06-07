package com.pageable.service;

import com.pageable.dao.EmployeeDao;
import com.pageable.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getEmployeesInPaging(int pageNo, int pageSize) {
        return employeeDao.getEmployeesInPaging(pageNo, pageSize);
    }

    public Page<Employee> getAllEmployeesInPaging(Pageable pageable) {
        return employeeDao.getAllEmployeesInPaging(pageable);
    }
}
