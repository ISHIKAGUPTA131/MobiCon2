package com.mobiconnect.repositories;

import com.mobiconnect.entities.Leave;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaveRepository extends CrudRepository<Leave, Integer> {
    public Leave findById(int id);
    public void save(int leaveId);

    public List<Leave> findByTypeContaining(String type);

}
