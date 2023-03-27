package com.mobiconnect.repositories;

import com.mobiconnect.entities.TimeSheetDay;
import org.springframework.data.repository.CrudRepository;

public interface TimeSheetDayRepository extends CrudRepository<TimeSheetDay, Integer> {

    public TimeSheetDay findById(int id);
    public void save(int timeSheetDayId);
}