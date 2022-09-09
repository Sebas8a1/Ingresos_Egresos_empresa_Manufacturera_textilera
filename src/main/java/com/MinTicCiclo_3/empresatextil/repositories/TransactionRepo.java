package com.MinTicCiclo_3.empresatextil.repositories;

import com.MinTicCiclo_3.empresatextil.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	@Query("SELECT t FROM Transaction t WHERE t.enterprise.id = ?1")
	List<Transaction> findAllTransactionsByenterprise(Long idEnterprise);

}
