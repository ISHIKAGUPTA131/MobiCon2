package com.mobiconnect.repositories;

import com.mobiconnect.entities.TimeSheet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeSheetRepository extends CrudRepository<TimeSheet, Integer> {

    public TimeSheet findById(int id);
    public void save(int timeSheetId);

    public List<TimeSheet> findByStatusContaining(String status);
}