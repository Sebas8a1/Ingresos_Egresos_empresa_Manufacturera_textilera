package com.MinTicCiclo_3.empresatextil.controller;

import com.MinTicCiclo_3.empresatextil.entity.Employee;
import com.MinTicCiclo_3.empresatextil.services.EmployeeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController   {
    @Autowired
    private final EmployeeServ employeeServ;

    public FrontController(EmployeeServ employeeServ) {
        this.employeeServ = employeeServ;
    }

    /*@GetMapping("/employee")
    public List<Employee> getEmployeeById() {
        return employeeServ.getAllEmployees();
    }*/

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employees = employeeServ.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

}
