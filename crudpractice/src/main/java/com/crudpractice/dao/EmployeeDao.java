package com.crudpractice.dao;

import com.crudpractice.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    EmployeeEntity createEmp(EmployeeEntity employee);

    List<EmployeeEntity> findAllEmp();

    Optional<EmployeeEntity> findEmpById(Long empId);

    EmployeeEntity saveUpdatedEmp(EmployeeEntity empById);

    void deleteById(EmployeeEntity empById);
}
