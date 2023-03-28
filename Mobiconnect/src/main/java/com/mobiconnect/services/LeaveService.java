package com.mobiconnect.services;


import com.mobiconnect.entities.Leave;
import com.mobiconnect.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    // search Leaves by type
    public List<Leave> searchLeavesByType(String type) {
        return leaveRepository.findByTypeContaining(type);
    }

    //get all leaves
    public List<Leave> getAllLeaves()
    {
        List<Leave>list=(List<Leave>)this.leaveRepository.findAll();
        return list;
    }


    //get leave by id
    public Leave getLeaveById(int id)
    {
        Leave leave=null;
        try{
            leave=this.leaveRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return leave;
    }


    //adding the leaves
    public Leave addLeaves(Leave l)
    {
        Leave result=leaveRepository.save(l);
        return result;
    }



    //delete the leaves
    public void deleteLeave(int lid)
    {
        leaveRepository.deleteById(lid);
    }



    //update the leaves
    public void updateLeaves(Leave leave, int leaveId)
    {
        leave.setId(leaveId);
        leaveRepository.save(leave);
    }
}
