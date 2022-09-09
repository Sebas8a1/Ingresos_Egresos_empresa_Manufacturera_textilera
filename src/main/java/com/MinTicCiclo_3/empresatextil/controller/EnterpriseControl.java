package com.MinTicCiclo_3.empresatextil.controller;

import com.MinTicCiclo_3.empresatextil.entity.Enterprise;
import com.MinTicCiclo_3.empresatextil.services.EnterpriseServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseControl {
    @Autowired
    private EnterpriseServ enterpriseServ;

    @GetMapping("/enterprise")
    public List<Enterprise> getAllEnterprises() {

        return enterpriseServ.getAllEnterprises();
    }

    @PostMapping("/enterprise")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseServ.createEnterprise(enterprise);
    }

    @DeleteMapping("/enterprise/{id}")
    public void deleteEnterprise(@PathVariable Long id) {
        enterpriseServ.deleteEnterprise(id);
    }

    @PutMapping("/enterprise")
    public Enterprise updateEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseServ.createEnterprise(enterprise);
    }

    @GetMapping("/enterprise/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id) {
        return enterpriseServ.getEnterpriseById(id);
    }

    @PatchMapping("/enterprise/{id}")
    public Enterprise updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        return enterpriseServ.createEnterprise(enterprise);
    }

}
