package com.SuperMasters.Ciclo3.services;

import com.SuperMasters.Ciclo3.entities.Empleado;
import com.SuperMasters.Ciclo3.repositories.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServ {
	@Autowired
	EmpleadoRepo empleadoRepo;

	//Encontrar todas los empleados
	public List<Empleado> getAll() {
		return (List<Empleado>) empleadoRepo.findAll();
	}

	//Buscar empresa por id
	public Empleado getById(Long id) {
		return empleadoRepo.findById(id).orElse(null);
	}

	//Guardar y/o actualizar empleado
	public boolean saveOrUpdate(Empleado empleado) {
		Empleado empleado1 = empleadoRepo.save(empleado);
		return empleadoRepo.findById(empleado1.getId()).isPresent();
	}

	//Eliminar empleado
	public boolean delete(Long id) {
		try {
			empleadoRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Buscar empleados por empresa
	public List<Empleado> getByEmpresa(Long id){
		return empleadoRepo.findByempresa_id(id);
	}
}
