package com.mobiconnect.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "timesheet_tbl")
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    private int totalHours;
    private int leaveHours;
    private int holidayHours;
    private String approver;
    private String status;


    public TimeSheet(int id, Date startDate, Date endDate, int totalHours, int leaveHours, int holidayHours, String approver, String status, Project project, TimeSheetDay timeSheetDays) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalHours = totalHours;
        this.leaveHours = leaveHours;
        this.holidayHours = holidayHours;
        this.approver = approver;
        this.status = status;
    }

    public TimeSheet(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getLeaveHours() {
        return leaveHours;
    }

    public void setLeaveHours(int leaveHours) {
        this.leaveHours = leaveHours;
    }

    public int getHolidayHours() {
        return holidayHours;
    }

    public void setHolidayHours(int holidayHours) {
        this.holidayHours = holidayHours;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
