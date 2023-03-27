package com.mobiconnect.services;

import java.util.List;

import com.mobiconnect.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiconnect.entities.Employee;
import com.mobiconnect.repositories.EmployeeRepository;

@Component
public class EmpTableService {
    @Autowired
    private EmployeeRepository empTableRepository;

    // search employees by name
    public List<Employee> searchEmployeesByName(String name) {
        return empTableRepository.findByNameContaining(name);
    }

     //get all employees
     public List<Employee> getAllEmp()
     {
         List<Employee>list=(List<Employee>)this.empTableRepository.findAll();
         return list;
     }


      //get emp by id
    public Employee getEmpById(int id)
    {
        Employee employeeTable=null;
        try{
        employeeTable=this.empTableRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employeeTable;
    }
 

     //adding employees
     public Employee addEmp(Employee e1)
     {
         Employee result=empTableRepository.save(e1);
         return result;
     }



      //delete employee
    public void deleteEmp(int eid)
    {
    
        empTableRepository.deleteById(eid);
    }

    //update employee
    public void updateEmp(Employee employeeTable, int empId)
    {
        employeeTable.setId(empId);
        empTableRepository.save(employeeTable);
    }
}
