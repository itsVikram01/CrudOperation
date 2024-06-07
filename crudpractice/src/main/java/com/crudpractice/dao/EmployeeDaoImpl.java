package com.crudpractice.dao;

import com.crudpractice.entity.EmployeeEntity;
import com.crudpractice.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private final EmployeeRepository repository;
    public EmployeeDaoImpl(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public EmployeeEntity createEmp(EmployeeEntity employee) {
        return repository.save(employee);
    }

    @Override
    public List<EmployeeEntity> findAllEmp() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findEmpById(Long empId) {
        return repository.findById(empId);
    }

    @Override
    public EmployeeEntity saveUpdatedEmp(EmployeeEntity empById) {
        return repository.save(empById);
    }

    @Override
    public void deleteById(EmployeeEntity empById) {
        repository.delete(empById);
    }


}
