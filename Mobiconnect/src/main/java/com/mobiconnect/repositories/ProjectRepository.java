package com.mobiconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mobiconnect.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer>{
    public Project findById(int id);
    public void save(int projectId);

}
