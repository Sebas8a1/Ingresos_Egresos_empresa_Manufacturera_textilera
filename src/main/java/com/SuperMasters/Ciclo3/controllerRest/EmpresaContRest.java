package com.SuperMasters.Ciclo3.controllerRest;


import com.SuperMasters.Ciclo3.entities.Empresa;
import com.SuperMasters.Ciclo3.services.EmpresaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaContRest {

	@Autowired
	EmpresaServ empresaServ;

	//Obtener todas las empresas
	@GetMapping("/empresaRest")
	public List<Empresa> viewEmpresas() {
		return empresaServ.getAll();
	}

	//Crear una nueva empresa
	@PostMapping("/empresaRest")
	public Empresa newEmpresa(@RequestBody Empresa empresa) {
		empresaServ.saveOrUpdate(empresa);
		return empresa;
	}

	//Obtener una empresa en especifico
	@GetMapping("/empresaRest/{id}")
	public Empresa getEmpresa(@PathVariable Long id) {
		return empresaServ.getById(id);
	}

	//Actualizar una empresa en especifico
	@PatchMapping("/empresaRest/{id}")
	public Empresa updateEmpresa(@RequestBody Empresa empresa, @PathVariable Long id) {
		Empresa empresa1 = empresaServ.getById(id);
		empresa1.setNombre(empresa.getNombre());
		empresa1.setDireccion(empresa.getDireccion());
		empresa1.setTelefono(empresa.getTelefono());
		empresa1.setNit(empresa.getNit());
		empresaServ.saveOrUpdate(empresa1);
		return empresa1;
	}

	//Eliminar una empresa en especifico
	@DeleteMapping("/empresaRest/{id}")
	public String deleteEmpresa(@PathVariable Long id) {
		empresaServ.delete(id);
		return "Empresa eliminada";
	}

}
