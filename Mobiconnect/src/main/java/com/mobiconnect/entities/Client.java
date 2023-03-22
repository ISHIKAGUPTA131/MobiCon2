package com.mobiconnect.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "client_tbl")
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private String location;
	private String start_date;
	private String end_date;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id",referencedColumnName = "id")
	private List<Project>projectTable;


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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public List<Project> getProjectTable() {
		return projectTable;
	}
	public void setProjectTable(List<Project> projectTable) {
		this.projectTable = projectTable;
	}
	public Client(int id, String name, String location, String start_date, String end_date,
				  List<Project> projectTable) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.projectTable = projectTable;
	}
   public Client()
   {

   }
}