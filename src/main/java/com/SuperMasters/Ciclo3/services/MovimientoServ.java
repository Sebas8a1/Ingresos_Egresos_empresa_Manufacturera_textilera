package com.SuperMasters.Ciclo3.services;

import com.SuperMasters.Ciclo3.entities.Movimiento;
import com.SuperMasters.Ciclo3.repositories.MovimientoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServ {

	@Autowired
	MovimientoRepo movimientoRepo;

	//Encontrar todas los movimientos
	public List<Movimiento> getAll() {
		return (List<Movimiento>) movimientoRepo.findAll();
	}

	//Buscar movimiento por id
	public Movimiento getById(Long id) {
		return movimientoRepo.findById(id).orElse(null);
	}

	//Guardar y/o actualizar movimiento
	public boolean saveOrUpdate(Movimiento movimiento) {
		Movimiento movimiento1 = movimientoRepo.save(movimiento);
		return movimientoRepo.findById(movimiento1.getId()).isPresent();
	}

	//Eliminar movimiento
	public boolean delete(Long id) {
		try {
			movimientoRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	//Encontrar movimientos por empleado
	public List<Movimiento> getByEmpleado(Long id){
		return movimientoRepo.findByempleado_id(id);
	}

	//Encontrar movimientos por empresa
	public List<Movimiento> getByEmpresa(Long id){
		return movimientoRepo.findByempresa_id(id);
	}
}
