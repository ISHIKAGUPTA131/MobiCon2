package com.mobiconnect.services;

import java.util.List;

import com.mobiconnect.entities.Client;
import com.mobiconnect.entities.TimeSheetDay;
import com.mobiconnect.repositories.TimeSheetDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TimeSheetDayService {
    @Autowired
    private TimeSheetDayRepository timeSheetDayRepository;

    // search clients by name
    public List<TimeSheetDay> searchTimeSheetByWeek(Integer week) {
        return timeSheetDayRepository.findByWeekContaining(week);
    }

    //get all TimeSheetDays
    public List<TimeSheetDay> getAllTimeSheetDays()
    {
        List<TimeSheetDay>list=(List<TimeSheetDay>)this.timeSheetDayRepository.findAll();
        return list;
    }


    //get timeSheetDays by id
    public TimeSheetDay getTimeSheetDayById(int id)
    {
        TimeSheetDay timeSheetDay=null;
        try{
            timeSheetDay=this.timeSheetDayRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return timeSheetDay;
    }


    //adding the timeSheetDays
    public TimeSheetDay addTimeSheetDays(TimeSheetDay t)
    {

        TimeSheetDay result=timeSheetDayRepository.save(t);
        return result;
    }



    //delete the timeSheetDays
    public void deleteTimeSheetDays(int tid)
    {
        timeSheetDayRepository.deleteById(tid);
    }



    //update the timeSheetDays
    public void updateTimeSheetDays(TimeSheetDay timeSheetDay, int timeSheetDayId)
    {
        timeSheetDay.setId(timeSheetDayId);
        timeSheetDayRepository.save(timeSheetDay);
    }
}
