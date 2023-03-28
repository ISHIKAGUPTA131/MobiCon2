package com.mobiconnect.controllers;


import com.mobiconnect.entities.TimeSheet;
import com.mobiconnect.services.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TimeSheetController {
    @Autowired
    private TimeSheetService timeSheetService;

    // search timeSheet by status
    @GetMapping("/timesheets/search")
    public ResponseEntity<List<TimeSheet>> searchTimeSheetsByStatus(@RequestParam String status) {
        List<TimeSheet> timeSheets = timeSheetService.searchTimeSheetByStatus(status);
        if (timeSheets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(timeSheets);
    }


    //get all TimeSheets
    @GetMapping("/timesheets")
    public ResponseEntity<List<TimeSheet>> getTimeSheets()
    {
        List<TimeSheet>list=timeSheetService.getAllTimeSheets();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    //get timeSheet by id
    @GetMapping("/timesheets/{id}")
    public ResponseEntity<TimeSheet> getTimeSheet(@PathVariable("id")int id)
    {
        TimeSheet timeSheet=timeSheetService.getTimeSheetById(id);
        if(timeSheet==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(timeSheet));
    }


    //save projects
    @PostMapping("/timesheets")
    public ResponseEntity<Optional<TimeSheet>> addTimeSheet(@RequestBody TimeSheet timeSheet)
    {
        TimeSheet t=null;
        try{
            t=this.timeSheetService.addTimeSheet(timeSheet);
            System.out.println(timeSheet);
            return ResponseEntity.ok(Optional.of(t));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //delete timeSheet
    @DeleteMapping("/timesheets/{timeSheetId}")
    public ResponseEntity<Void> deleteTimeSheet(@PathVariable("timeSheetId")int timeSheetId)
    {
        try{
            this.timeSheetService.deleteTimeSheet(timeSheetId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update TimeSheet
    @PutMapping("/timesheets/{timeSheetId}")
    public ResponseEntity<TimeSheet>updateTimeSheet(@RequestBody TimeSheet timeSheet, @PathVariable("timeSheetId")int timeSheetId)
    {
        try{
            this.timeSheetService.updateTimeSheet(timeSheet,timeSheetId);
            return ResponseEntity.ok().body(timeSheet);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
