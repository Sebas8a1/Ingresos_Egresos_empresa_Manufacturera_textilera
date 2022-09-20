package com.SuperMasters.Ciclo3.repositories;

import com.SuperMasters.Ciclo3.entities.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepo extends CrudRepository<Empresa, Long> {

}

