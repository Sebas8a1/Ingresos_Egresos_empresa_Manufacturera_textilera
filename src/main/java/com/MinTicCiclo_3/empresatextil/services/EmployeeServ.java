package com.MinTicCiclo_3.empresatextil.services;

import com.MinTicCiclo_3.empresatextil.entity.Employee;
import com.MinTicCiclo_3.empresatextil.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServ {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepo.findAll());
    }

    public Employee getEmployeeById(Long idEmployee) {

        Optional<Employee> opcionalEmployee =  this.employeeRepo.findById(idEmployee);
        if (opcionalEmployee.isEmpty() ) {
            return null;
        }
        return opcionalEmployee.get();
    }

    public Employee createEmployee(Employee newEmployee) {
        return this.employeeRepo.save(newEmployee);
    }

    public void deleteEmployee(Long idEmployee) {
        this.employeeRepo.deleteById(idEmployee);
    }




}
