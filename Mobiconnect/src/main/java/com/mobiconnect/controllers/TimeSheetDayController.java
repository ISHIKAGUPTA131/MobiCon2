package com.mobiconnect.controllers;


import com.mobiconnect.entities.Leave;
import com.mobiconnect.entities.TimeSheetDay;
import com.mobiconnect.services.TimeSheetDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TimeSheetDayController {
    @Autowired
    private TimeSheetDayService timeSheetDayService;

    // search TimeSheet by week
    @GetMapping("/days/search")
    public ResponseEntity<List<TimeSheetDay>> searchTimeSheetByWeek(@RequestParam Integer week) {
        List<TimeSheetDay> timeSheetDays = timeSheetDayService.searchTimeSheetByWeek(week);
        if (timeSheetDays.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(timeSheetDays);
    }


    //get all timeSheetDays
    @GetMapping("/days")
    public ResponseEntity<List<TimeSheetDay>> getTimeSheetDays()
    {
        List<TimeSheetDay>list=timeSheetDayService.getAllTimeSheetDays();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }


    //get TimeSheetDays by id
    @GetMapping("/days/{id}")
    public ResponseEntity<TimeSheetDay> getTimeSheetDay(@PathVariable("id")int id)
    {
        TimeSheetDay timeSheetDay=timeSheetDayService.getTimeSheetDayById(id);
        if(timeSheetDay==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(timeSheetDay));
    }


    //save timeSheetDays
    @PostMapping("/days")
    public ResponseEntity<Optional<TimeSheetDay>> addTimeSheetDays(@RequestBody TimeSheetDay timeSheetDay)
    {
        TimeSheetDay t=null;
        try{
            t=this.timeSheetDayService.addTimeSheetDays(timeSheetDay);
            System.out.println(timeSheetDay);
            return ResponseEntity.ok(Optional.of(t));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //delete TimeSheetDays
    @DeleteMapping("/days/{timeSheetDayId}")
    public ResponseEntity<Void> deleteTimeSheetDays(@PathVariable("timeSheetDayId")int timeSheetDayId)
    {
        try{
            this.timeSheetDayService.deleteTimeSheetDays(timeSheetDayId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update TimeSheetDays
    @PutMapping("/days/{timeSheetDayId}")
    public ResponseEntity<TimeSheetDay>updateTimeSheetDays(@RequestBody TimeSheetDay timeSheetDay, @PathVariable("timeSheetDayId")int timeSheetDayId)
    {
        try{
            this.timeSheetDayService.updateTimeSheetDays(timeSheetDay,timeSheetDayId);
            return ResponseEntity.ok().body(timeSheetDay);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
