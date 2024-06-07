package com.crudpractice.service;

import com.crudpractice.dao.EmployeeDao;
import com.crudpractice.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeDao dao;
    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }


    public EmployeeEntity createEmp(EmployeeEntity employee) {
        return dao.createEmp(employee);
    }

    public List<EmployeeEntity> findAllEmp() {
        return dao.findAllEmp();
    }

    public Optional<EmployeeEntity> findEmpById(Long empId) {
        return dao.findEmpById(empId);
    }

    public EmployeeEntity saveUpdatedEmp(EmployeeEntity empById) {
        return dao.saveUpdatedEmp(empById);
    }

    public void deleteById(EmployeeEntity empById) {
        dao.deleteById(empById);
    }
}
