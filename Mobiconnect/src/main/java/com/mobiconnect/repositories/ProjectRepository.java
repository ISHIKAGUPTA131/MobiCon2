package com.mobiconnect.repositories;

import com.mobiconnect.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import com.mobiconnect.entities.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Integer>{
    public Project findById(int id);
    public void save(int projectId);

    public List<Project> findByNameContaining(String name);

}
