package com.mobiconnect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_tbl")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String type;
    private String start_date;
    private String end_date;
    private int day;
    private String approver;
    private String status;


    public Leave(int id, String startDate, String endDate, int day, String approver, String status) {
        this.id = id;
        this.start_date = startDate;
        this.end_date = endDate;
        this.day = day;
        this.approver = approver;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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

    public Leave(){

    }

}
