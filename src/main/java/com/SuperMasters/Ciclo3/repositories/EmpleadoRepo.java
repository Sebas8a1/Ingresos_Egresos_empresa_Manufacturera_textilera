package com.SuperMasters.Ciclo3.repositories;

import com.SuperMasters.Ciclo3.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmpleadoRepo extends CrudRepository<Empleado, Long> {
	//Encontrar todos los empleados de una empresa
	/*@Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)*/
	public List<Empleado> findByempresa_id(Long empresa);


}

