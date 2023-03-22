package com.mobiconnect.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "project_tbl")
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private String owner_client;
	private String owner_consultant;
	private String start_date;
	private String end_date;
	private String status;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employee> employee;

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

	public String getOwner_client() {
		return owner_client;
	}

	public void setOwner_client(String owner_client) {
		this.owner_client = owner_client;
	}

	public String getOwner_consultant() {
		return owner_consultant;
	}

	public void setOwner_consultant(String owner_consultant) {
		this.owner_consultant = owner_consultant;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getEmployeeTable() {
		return employee;
	}

	public void setEmployeeTable(List<Employee> employeeTable) {
		this.employee = employeeTable;
	}

	public Project(int id, String name, String owner_client, String owner_consultant, String start_date,
				   String end_date, String status, List<Employee> employee) {
		this.id = id;
		this.name = name;
		this.owner_client = owner_client;
		this.owner_consultant = owner_consultant;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status = status;
		this.employee = employee;
	}

  public Project()
  {

  }
}