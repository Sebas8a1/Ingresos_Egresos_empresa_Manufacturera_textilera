package com.SuperMasters.Ciclo3.services;

import com.SuperMasters.Ciclo3.entities.Empresa;
import com.SuperMasters.Ciclo3.repositories.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServ {

	@Autowired
	 EmpresaRepo empresaRepo;

	//Encontrar todas las empresas
	public List<Empresa> getAll(){
		return (List<Empresa>) empresaRepo.findAll();
	}

	//Buscar empresa por id
	public Empresa getById(Long id){
		return empresaRepo.findById(id).orElse(null);
	}

	//Guardar y/o actualizar empresa
	public boolean saveOrUpdate(Empresa empresa){
		Empresa emp=empresaRepo.save(empresa);
		if (empresaRepo.findById(emp.getId())!=null){
			return true;
		}
		return false;
	}

	//Eliminar empresa
	public boolean delete(Long id){
		try{
			empresaRepo.deleteById(id);
			return true;
		}catch (Exception e){
			return false;
		}
	}

}
