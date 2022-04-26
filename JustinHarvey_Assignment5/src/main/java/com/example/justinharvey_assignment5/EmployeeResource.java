package com.example.justinharvey_assignment5;


import Model.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Path("/employees")
public class EmployeeResource {


    private static Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

    static {
        Employee employee1 = new Employee(1, "Wanda", "Maximoff", "wmaxy123@gmail.com", new java.sql.Date(2001, 03, 02), 120000.00);
        Employee employee2 = new Employee(2, "Bruce", "Wayne", "bwayenent@gmail.com", new java.sql.Date(2002, 05, 19), 250000.00);
        Employee employee3 = new Employee(3, "Clark", "Kent", "dailyglobeck@gmail.com", new java.sql.Date(2004, 02, 15), 40000.00);

        employeeMap.put(employee1.getId(), employee1);
        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee3.getId(), employee3);
    }

    @GET
    @Produces("text/plain")
    public String welcome() {
        return "WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM";
    }

    @GET
    @Path("/all")
    @Produces("application/xml")
    public List<Employee> listEmployees() {
        return new ArrayList<Employee>(employeeMap.values());
    }

    @GET
    @Path("/employee/{id}")
    @Produces("application/xml")
    public Employee getEmployee(@PathParam("id") int employeeId) {
        return employeeMap.get(employeeId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employeeMap.get(employee.getId());
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeMap.remove(id);
        return Response.noContent().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(Employee employee) {
        if (employeeMap.get(employee.getId()) == null) {
            return Response.status(404).build();
        } else {
            employeeMap.put(employee.getId(), employee);
        }
        return Response.ok(employeeMap.get(employee.getId())).build();
    }

}
