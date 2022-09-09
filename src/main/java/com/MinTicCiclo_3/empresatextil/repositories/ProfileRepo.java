package com.MinTicCiclo_3.empresatextil.repositories;

import com.MinTicCiclo_3.empresatextil.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends CrudRepository<Profile,Long> {
}
