package com.mobiconnect.services;

import java.util.List;

import com.mobiconnect.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobiconnect.entities.Project;
import com.mobiconnect.repositories.ProjectRepository;

@Component
public class ProjectTableService {
    @Autowired
    private ProjectRepository projectTableRepository;

    // search projects by name
    public List<Project> searchProjectsByName(String name) {
        return projectTableRepository.findByNameContaining(name);
    }

     //get all projects
     public List<Project> getAllProjects()
     {
         List<Project>list=(List<Project>)this.projectTableRepository.findAll();
         return list;
     }
    

      //get  project by id
    public Project getProjectById(int id)
    {
        Project projectTable=null;
        try{
        projectTable=this.projectTableRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return projectTable;
    }


     //adding the projects
     public Project addProject(Project p)
     {

         Project result=projectTableRepository.save(p);
         return result;
     }



      //delete the project
    public void deleteProject(int pid)
    {
        projectTableRepository.deleteById(pid);
    }



    //update the project
    public void updateProject(Project projectTable, int projectId)
    {
        projectTable.setId(projectId);
        projectTableRepository.save(projectTable);
    }
}
