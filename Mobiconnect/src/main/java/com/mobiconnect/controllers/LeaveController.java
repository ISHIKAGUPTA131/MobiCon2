package com.mobiconnect.controllers;

import com.mobiconnect.entities.Client;
import com.mobiconnect.entities.Leave;
import com.mobiconnect.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    // search Leaves by type
    @GetMapping("/leaves/search")
    public ResponseEntity<List<Leave>> searchLeavesByType(@RequestParam String type) {
        List<Leave> leaves = leaveService.searchLeavesByType(type);
        if (leaves.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(leaves);
    }


    //get all Leaves
    @GetMapping("/leaves")
    public ResponseEntity<List<Leave>> getLeaves()
    {
        List<Leave>list=leaveService.getAllLeaves();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    //get leave by id
    @GetMapping("/leaves/{id}")
    public ResponseEntity<Leave> getLeave(@PathVariable("id")int id)
    {
        Leave leave=leaveService.getLeaveById(id);
        if(leave==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(leave));
    }


    //save leaves
    @PostMapping("/leaves")
    public ResponseEntity<Optional<Leave>> addProject(@RequestBody Leave leave)
    {
        Leave l=null;
        try{
            l=this.leaveService.addLeaves(leave);
            System.out.println(leave);
            return ResponseEntity.ok(Optional.of(l));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //delete leave
    @DeleteMapping("/leaves/{leaveId}")
    public ResponseEntity<Void> deleteLeave(@PathVariable("leaveId")int leaveId)
    {
        try{
            this.leaveService.deleteLeave(leaveId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update Leaves
    @PutMapping("/leaves/{leaveId}")
    public ResponseEntity<Leave>updateLeaves(@RequestBody Leave leave, @PathVariable("leaveId")int leaveId)
    {
        try{
            this.leaveService.updateLeaves(leave,leaveId);
            return ResponseEntity.ok().body(leave);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
