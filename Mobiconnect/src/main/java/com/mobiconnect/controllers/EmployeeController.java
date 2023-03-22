package com.mobiconnect.controllers;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobiconnect.entities.Employee;
import com.mobiconnect.services.EmpTableService;

@RestController
public class EmployeeController {
    @Autowired
    private EmpTableService empTableService;


     @GetMapping("/employee")
     public ResponseEntity<List<Employee>> getEmp()
     {
         List<Employee>list=empTableService.getAllEmp();
         if(list.size()<=0)
         {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
     }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmp(@PathVariable("id")int id)
    {
        Employee employeeTable=empTableService.getEmpById(id);
        if(employeeTable==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employeeTable));
    }

    @PostMapping("/employee")
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

     @PutMapping("/employee/{empId}")
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
