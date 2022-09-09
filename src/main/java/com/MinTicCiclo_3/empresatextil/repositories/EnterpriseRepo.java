package com.MinTicCiclo_3.empresatextil.repositories;

import com.MinTicCiclo_3.empresatextil.entity.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepo extends CrudRepository<Enterprise,Long> {
}
