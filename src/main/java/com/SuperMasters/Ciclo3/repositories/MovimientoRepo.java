package com.SuperMasters.Ciclo3.repositories;

import com.SuperMasters.Ciclo3.entities.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepo extends CrudRepository<Movimiento, Long> {

	/*@Query(value="SELECT * FROM movimiento where empleado_id= ?1", nativeQuery=true)*/
	public List<Movimiento> findByempleado_id(Long empleado);

	//Encontrar movimientos por empresa
	@Query(value="SELECT * FROM movimiento where empleado_id in (SELECT id FROM empleado WHERE empresa_id= ?1)", nativeQuery=true)
	public List<Movimiento> findByempresa_id(Long id);

}

