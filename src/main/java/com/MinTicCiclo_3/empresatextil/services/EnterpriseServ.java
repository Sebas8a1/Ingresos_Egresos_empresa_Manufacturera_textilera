package com.MinTicCiclo_3.empresatextil.services;

import com.MinTicCiclo_3.empresatextil.entity.Enterprise;
import com.MinTicCiclo_3.empresatextil.repositories.EnterpriseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServ {
	@Autowired
	private EnterpriseRepo enterpriseRepo;

	public List<Enterprise> getAllEnterprises() {

		return (List<Enterprise>) this.enterpriseRepo.findAll();
	}

	public Enterprise getEnterpriseById(Long idEnterprise) {
		Optional<Enterprise> opcionalEnterprise = this.enterpriseRepo.findById(idEnterprise);
		if (opcionalEnterprise.isEmpty()) {
			return null;
		}
		return opcionalEnterprise.get();
	}

	public Enterprise createEnterprise(Enterprise newEnterprise) {

		return this.enterpriseRepo.save(newEnterprise);
	}

	public void deleteEnterprise(Long idEnterprise) {
		this.enterpriseRepo.deleteById(idEnterprise);
	}


}
