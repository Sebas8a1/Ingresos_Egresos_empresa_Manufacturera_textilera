package com.SuperMasters.Ciclo3.controllerRest;

import com.SuperMasters.Ciclo3.entities.Movimiento;
import com.SuperMasters.Ciclo3.services.MovimientoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoContRest {

	@Autowired
	MovimientoServ movimientoServ;

	//Obtener todos los movimientos
	@GetMapping("/movimientoRest")
	public List<Movimiento> viewMovimientos() {
		return movimientoServ.getAll();
	}

	//Obtener un movimiento en especifico
	@GetMapping("/movimientoRest/{id}")
	public Movimiento getMovimiento(@PathVariable Long id) {
		return movimientoServ.getById(id);
	}

	//Crear un nuevo movimiento
	@PostMapping("/movimientoRest")
	public Movimiento newMovimiento(@RequestBody Movimiento movimiento) {
		movimientoServ.saveOrUpdate(movimiento);
		return movimiento;
	}

	//Actualizar un movimiento en especifico
	@PatchMapping("/movimientoRest/{id}")
	public Movimiento updateMovimiento(@RequestBody Movimiento movimiento, @PathVariable Long id) {
		Movimiento movimiento1 = movimientoServ.getById(id);
		movimiento1.setMonto(movimiento.getMonto());
		movimiento1.setConcepto(movimiento.getConcepto());
		movimiento1.setEmpleado(movimiento.getEmpleado());
		movimientoServ.saveOrUpdate(movimiento1);
		return movimiento1;
	}

	//Eliminar un movimiento en especifico
	@DeleteMapping("/movimientoRest/{id}")
	public String deleteMovimiento(@PathVariable Long id) {
		movimientoServ.delete(id);
		return "Movimiento eliminado";
	}

	//Obtener los movimientos de un empleado en especifico
	@GetMapping("/movimientoRest/empleado/{id}")
	public List<Movimiento> getMovimientosEmpleado(@PathVariable("id") Long id) {
		return movimientoServ.getByEmpleado(id);
	}

	//Obtener los movimientos de una empresa en especifico
	@GetMapping("/movimientoRest/empresa/{id}")
	public List<Movimiento> getMovimientosEmpresa(@PathVariable("id") Long id) {
		return movimientoServ.getByEmpresa(id);
	}




}
