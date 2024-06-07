package com.pageable.dao;

import com.pageable.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeesInPaging(int pageNo, int pageSize);

    Page<Employee> getAllEmployeesInPaging(Pageable pageable);

}
