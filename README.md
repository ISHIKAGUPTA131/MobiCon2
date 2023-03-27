##Employee_Management

This is a Spring Boot API project that allows management of employees and their projects related to clients.

## Prerequisites

- Java 17 
- Maven

## Getting Started

To run the project, follow these steps:

1. Clone the repository.
2. Navigate to the project directory.
3. Run Application.java file.


## API Endpoints

The following API endpoints are available:

For Many-To-One mapping

For clients:

- GET /client - Retrieve all clients
- GET /client/{id} - Retrieve a specific client
- POST /client - Create a new client
- PUT /client/{id} - Update a client
- DELETE /client/{id} - Delete a client

Sample JSON data:

{
    "id": 2,
    "name": "Pushpak",
    "location": "Delhi",
    "start_date": "2022-01-01",
    "end_date": "2022-12-31",
    "projectTable": [
        {
            "id": 6,
            "name": "Project 1",
            "owner_client": "Client 1",
            "owner_consultant": "Consultant 1",
            "start_date": "2022-01-01",
            "end_date": "2022-12-31",
            "status": "Active",
            "timeSheetDay": [
                {
                    "id": 9,
                    "day1": "Monday",
                    "day2": "Tuesday",
                    "day3": "Wednesday",
                    "day4": "Thursday",
                    "day5": "Friday",
                    "day6": "Saturday",
                    "day7": "Sunday",
                    "week": 1
                },
                {
                    "id": 10,
                    "day1": "Monday",
                    "day2": "Tuesday",
                    "day3": "Wednesday",
                    "day4": "Thursday",
                    "day5": "Friday",
                    "day6": "Saturday",
                    "day7": "Sunday",
                    "week": 2
                }
            ],
            "employeeTable": [
                {
                    "id": 7,
                    "name": "Ishika",
                    "email": "ishika@example.com",
                    "contact": "112-56-7890",
                    "gender": "female",
                    "dob": "1990-01-01",
                    "designation": "Software Engineer",
                    "address": "123 Main St, Anytown USA",
                    "work_location": "Office 1",
                    "date_of_joining": "2020-01-01",
                    "date_of_exit": "2028-02-01",
                    "manager": "Jasleen",
                    "total_leaves": "20",
                    "leave_balance": "15",
                    "leave": [
                        {
                            "id": 5,
                            "type": "Sick Leave",
                            "start_date": "2022-05-01",
                            "end_date": "2022-05-01",
                            "day": 5,
                            "approver": "Varsha",
                            "status": "Pending"
                        },
                        {
                            "id": 6,
                            "type": "Sick Leave",
                            "start_date": "2022-05-01",
                            "end_date": "2022-05-01",
                            "day": 5,
                            "approver": "Varsha",
                            "status": "Pending"
                        }
                    ]
                },
                {
                    "id": 8,
                    "name": "Ishika123",
                    "email": "ishika123@example.com",
                    "contact": "123-456-7890",
                    "gender": "female",
                    "dob": "1990-01-01",
                    "designation": "Software Engineer",
                    "address": "Jammu, J&K",
                    "work_location": "Office 1",
                    "date_of_joining": "2020-01-01",
                    "date_of_exit": "2028-02-01",
                    "manager": "Bhavana",
                    "total_leaves": "20",
                    "leave_balance": "15",
                    "leave": [
                        {
                            "id": 7,
                            "type": "Sick Leave",
                            "start_date": "2022-05-01",
                            "end_date": "2022-05-01",
                            "day": 5,
                            "approver": "Varsha",
                            "status": "Pending"
                        },
                        {
                            "id": 8,
                            "type": "Sick Leave",
                            "start_date": "2022-05-01",
                            "end_date": "2022-05-01",
                            "day": 5,
                            "approver": "Varsha",
                            "status": "Pending"
                        }
                    ]
                }
            ]
        }
    ]
}

For Projects:

- GET /projects recieve all projects
- GET /projects/{id} recieve a specific project
- POST /projects - Create a new project
- PUT /projects/{id} - Update a project
- DELETE /projects/{id} - Delete a project

For Employees:

- GET /employee - Retrieve all employees
- GET /employee/{id} - Retrieve a specific employee
- POST /employee - Create a new employee
- PUT /employee/{id} - Update a employee
- DELETE /employeee/{id} - Delete a employee

For TimeSheetDays:

- GET /days - Retrieve all TimeSheetDays
- GET /days/{id} - Retrieve a specific data
- POST /days - Create a new data
- PUT /days/{id} - Update data
- DELETE /days/{id} - Delete a data from TimeSheetDays

For Leave:

- GET /leaves - Retrieve all leaves
- GET /leaves/{id} - Retrieve a specific leave data
- POST /leaves - Create a new leave data
- PUT /leaves/{id} - Update a leave data
- DELETE /leaves/{id} - Delete a leave data



## Dependencies

This project uses the following dependencies:

- Spring Boot
- Spring Data JPA
- Lombok
- PostgreSql

## Authors

- Ishika Gupta @ishikagupta100001@gmail.com
