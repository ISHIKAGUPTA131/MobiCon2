package com.mobiconnect.repositories;

import com.mobiconnect.entities.Client;
import org.springframework.data.repository.CrudRepository;

import com.mobiconnect.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
    public Employee findById(int id);

    public void save(int empId);
    public List<Employee> findByNameContaining(String name);

    
}
