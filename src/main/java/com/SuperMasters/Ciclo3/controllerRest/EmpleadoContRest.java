package com.SuperMasters.Ciclo3.controllerRest;

import com.SuperMasters.Ciclo3.entities.Empleado;
import com.SuperMasters.Ciclo3.repositories.EmpleadoRepo;
import com.SuperMasters.Ciclo3.services.EmpleadoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoContRest {

	@Autowired
	EmpleadoServ empleadoServ;

	//Obtener todos los empleados
	@GetMapping("/empleadoRest")
	public List<Empleado> viewEmpleados() {
		return empleadoServ.getAll();
	}

	//Obtener un empleado en especifico
	@GetMapping("/empleadoRest/{id}")
	public Empleado getEmpleado(@PathVariable Long id) {
		return empleadoServ.getById(id);
	}

	//Crear un nuevo empleado
	@PostMapping("/empleadoRest")
	public Empleado newEmpleado(@RequestBody Empleado empleado) {
		empleadoServ.saveOrUpdate(empleado);
		return empleado;
	}

	//Actualizar un empleado en especifico
	@PatchMapping("/empleadoRest/{id}")
	public Empleado updateEmpleado(@RequestBody Empleado empleado, @PathVariable Long id) {
		Empleado empleado1 = empleadoServ.getById(id);
		empleado1.setNombre(empleado.getNombre());
		empleado1.setCorreo(empleado.getCorreo());
		empleado1.setRol(empleado.getRol());
		empleado1.setEmpresa(empleado.getEmpresa());
		empleadoServ.saveOrUpdate(empleado1);
		return empleado1;
	}

	//Eliminar un empleado en especifico
	@DeleteMapping("/empleadoRest/{id}")
	public String deleteEmpleado(@PathVariable Long id) {
		empleadoServ.delete(id);
		return "Empleado eliminado";
	}

	//Obtener los empleados de una empresa en especifico
	@GetMapping("/empleadoRest/empresa/{id}")
	public List<Empleado> getEmpleadosEmpresa(@PathVariable("id") Long id) {
		return empleadoServ.getByEmpresa(id);
	}


}