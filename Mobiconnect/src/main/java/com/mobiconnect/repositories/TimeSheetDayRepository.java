package com.mobiconnect.repositories;

import com.mobiconnect.entities.Employee;
import com.mobiconnect.entities.TimeSheetDay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeSheetDayRepository extends CrudRepository<TimeSheetDay, Integer> {

    public TimeSheetDay findById(int id);
    public void save(int timeSheetDayId);

    public List<TimeSheetDay> findByWeekContaining(Integer week);
}