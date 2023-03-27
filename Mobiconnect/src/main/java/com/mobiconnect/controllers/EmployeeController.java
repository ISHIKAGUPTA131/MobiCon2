package com.mobiconnect.controllers;

import java.util.Optional;
import java.util.List;

import com.mobiconnect.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobiconnect.entities.Employee;
import com.mobiconnect.services.EmpTableService;

@RestController
public class EmployeeController {
    @Autowired
    private EmpTableService empTableService;

    // search clients by name
    @GetMapping("/employees/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String name) {
        List<Employee> employees = empTableService.searchEmployeesByName(name);
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employees);
    }


     @GetMapping("/employees")
     public ResponseEntity<List<Employee>> getEmp()
     {
         List<Employee>list=empTableService.getAllEmp();
         if(list.size()<=0)
         {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmp(@PathVariable("id")int id)
    {
        Employee employeeTable=empTableService.getEmpById(id);
        if(employeeTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employeeTable));
    }

    @PostMapping("/employees")
    public ResponseEntity<Optional<Employee>> addEmp(@RequestBody Employee employeeTable)
    {
        Employee em=null;
       try{
            em=this.empTableService.addEmp(employeeTable);
            System.out.println(employeeTable);
            return ResponseEntity.ok(Optional.of(em));
       }
       catch(Exception e)
       {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<Void> deleteEmp(@PathVariable("empId")int empId)
    {
       try{
        this.empTableService.deleteEmp(empId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

       }
    }

     @PutMapping("/employees/{empId}")
     public ResponseEntity<Employee>updateEmp(@RequestBody Employee employeeTable, @PathVariable("empId")int empId)
     {
         try{
             this.empTableService.updateEmp(employeeTable,empId);
             return ResponseEntity.ok().body(employeeTable);
         }
         catch(Exception e)
         {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }
}
