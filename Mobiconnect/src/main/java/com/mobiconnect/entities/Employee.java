package com.mobiconnect.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "emp_tbl")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
    private String name;
    private String email;
    private String contact;
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    private String designation;
    private String address;
    private String work_location;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_of_joining;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_of_exit;
    private String manager;
    private String total_leaves;
    private String leave_balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private List<Leave> leave;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Project> projects;
   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWork_location() {
        return work_location;
    }
    public void setWork_location(String work_location) {
        this.work_location = work_location;
    }
    public Date getDate_of_joining() {
        return date_of_joining;
    }
    public void setDate_of_joining(Date date_of_joining) {
        this.date_of_joining = date_of_joining;
    }
    public Date getDate_of_exit() {
        return date_of_exit;
    }
    public void setDate_of_exit(Date date_of_exit) {
        this.date_of_exit = date_of_exit;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getTotal_leaves() {
        return total_leaves;
    }
    public void setTotal_leaves(String total_leaves) {
        this.total_leaves = total_leaves;
    }
    public String getLeave_balance() {
        return leave_balance;
    }
    public void setLeave_balance(String leave_balance) {
        this.leave_balance = leave_balance;
    }
    public Employee(int id, String name, String email, String contact, String gender, Date dob,
                    String designation, String address, String work_location, Date date_of_joining, Date date_of_exit,
                    String manager, String total_leaves, String leave_balance, List<Leave> leaveTable, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
        this.dob = dob;
        this.designation = designation;
        this.address = address;
        this.work_location = work_location;
        this.date_of_joining = date_of_joining;
        this.date_of_exit = date_of_exit;
        this.manager = manager;
        this.total_leaves = total_leaves;
        this.leave_balance = leave_balance;
        this.projects = projects;
        this.leave = leave;
    }

    public Employee(){

    }


    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeaveTable(List<Leave> leaveTable) {
        this.leave = leave;
    }
}
