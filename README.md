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
    "end_date": "2022-12-31
    "location": "Delhi",
    "name": "Pushpak",
    "start_date":"2022-01-01",
    "projectTable": [
        {
            "end_date": "2022-12-31",
            "name": "Project 1",
            "owner_client": "Client 1",
            "owner_consultant": "Consultant 1",
            "start_date": "2022-01-01",
            "status": "Active"
        },
        {
            "end_date": "2022-12-31",
            "name": "Project 1",
            "owner_client": "Client 1",
            "owner_consultant": "Consultant 1",
            "start_date": "2022-01-01",
            "status": "Active"
        }
    ]
 }

For Projects:

- GET /projects recieve all projects
- GET /projects/{id} recieve a specific project
- POST /projects - Create a new project
- PUT /projects/{id} - Update a project
- DELETE /projects/{id} - Delete a project
 
For Many-To-Many mapping

For Employees:

- GET /employee - Retrieve all employees
- GET /employee/{id} - Retrieve a specific employee
- POST /employee - Create a new employee
- PUT /employee/{id} - Update a employee
- DELETE /employeee/{id} - Delete a employee

Sample JSON data:

{
    "end_date": "2022-12-31",
    "name": "Project 1",
    "owner_client": "Client 1",
    "owner_consultant": "Consultant 1",
    "start_date": "2022-01-01",
    "status": "Active",
    "employeeTable":[
                {
                    "address": "Jammu, India",
                    "contact": "122-343-5368",
                    "dob": "1990-01-01",
                    "date_of_exit": "2028-02-01",
                    "date_of_joining": "2020-01-01",
                    "designation": "Software Engineer",
                    "email": "radha123.com",
                    "gender": "Male",
                    "leave_balance": 15,
                    "manager": "Jhon",
                    "name": "ISHIKA",
                    "total_leaves": 20,
                    "work_location": "Office 1"
                    },
                    {
                    "address": "Jammu, India",
                    "contact": "122-343-5368",
                    "dob": "1990-01-01",
                    "date_of_exit": "2028-02-01",
                    "date_of_joining": "2020-01-01",
                    "designation": "Software Engineer",
                    "email": "radha123.com",
                    "gender": "Male",
                    "leave_balance": 15,
                    "manager": "Jhon",
                    "name": "ISHIKA",
                    "total_leaves": 20,
                    "work_location": "Office 1"
                    }
                ]
            }

## Dependencies

This project uses the following dependencies:

- Spring Boot
- Spring Data JPA
- Lombok
- PostgreSql

## Authors

- Ishika Gupta @ishikagupta100001@gmail.com
