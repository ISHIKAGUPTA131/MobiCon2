package com.mobiconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mobiconnect.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
    public Employee findById(int id);

    public void save(int empId);

    
}
