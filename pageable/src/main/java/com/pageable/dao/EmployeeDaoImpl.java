package com.pageable.dao;

import com.pageable.model.Employee;
import com.pageable.repository.EmployeeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepo employeeRepo;
    public EmployeeDaoImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployeesInPaging(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<Employee> employeePage = employeeRepo.findAll(pageable);
        return employeePage.getContent();
    }

    @Override
    public Page<Employee> getAllEmployeesInPaging(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

}
