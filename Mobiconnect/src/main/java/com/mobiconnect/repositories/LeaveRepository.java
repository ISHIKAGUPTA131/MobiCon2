package com.mobiconnect.repositories;

import com.mobiconnect.entities.Leave;
import com.mobiconnect.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface LeaveRepository extends CrudRepository<Leave, Integer> {
    public Leave findById(int id);
    public void save(int leaveId);
}
