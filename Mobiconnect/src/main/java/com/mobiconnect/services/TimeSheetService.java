package com.mobiconnect.services;

import com.mobiconnect.entities.TimeSheet;
import com.mobiconnect.repositories.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TimeSheetService {
    @Autowired
    private TimeSheetRepository timeSheetRepository;

    // search TimeSheet by status
    public List<TimeSheet> searchTimeSheetByStatus(String status) {

        return timeSheetRepository.findByStatusContaining(status);
    }


    //get all TimeSheets
    public List<TimeSheet> getAllTimeSheets()
    {
        List<TimeSheet>list=(List<TimeSheet>)this.timeSheetRepository.findAll();
        return list;
    }


    //get TimeSheet by id
    public TimeSheet getTimeSheetById(int id)
    {
        TimeSheet timeSheet=null;
        try{
            timeSheet=this.timeSheetRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return timeSheet;
    }


    //adding the TimeSheet data
    public TimeSheet addTimeSheet(TimeSheet t)
    {
        TimeSheet result=timeSheetRepository.save(t);
        return result;
    }



    //delete the TimeSheet
    public void deleteTimeSheet(int tid)
    {
        timeSheetRepository.deleteById(tid);
    }



    //update the timeSheet
    public void updateTimeSheet(TimeSheet timeSheet, int timeSheetId)
    {
        timeSheet.setId(timeSheetId);
        timeSheetRepository.save(timeSheet);
    }
}
