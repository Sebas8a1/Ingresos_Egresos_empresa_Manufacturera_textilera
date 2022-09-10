package com.MinTicCiclo_3.empresatextil.controller;

import com.MinTicCiclo_3.empresatextil.entity.Employee;
import com.MinTicCiclo_3.empresatextil.services.EmployeeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeControl {

    @Autowired
    private EmployeeServ employeeServ;


    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeServ.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeServ.createEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeServ.deleteEmployee(id);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeServ.createEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeServ.getEmployeeById(id);
    }


    @PatchMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeServ.createEmployee(employee);
    }


}
