package com.MinTicCiclo_3.empresatextil.services;


import com.MinTicCiclo_3.empresatextil.entity.Transaction;
import com.MinTicCiclo_3.empresatextil.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServ {
    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> getAllTransactions() {

        return (List<Transaction>) this.transactionRepo.findAll();
    }

    //find all transactions by enterprise id
    /*public List<Transaction> getAllTransactionsByEnterpriseId(Long idEnterprise) {

        return (List<Transaction>) this.transactionRepo.findAllById(idEnterprise);
    }*/

    public Transaction getTransactionById(Long idTransaction) {

        Optional<Transaction> opcionalTransaction = this.transactionRepo.findById(idTransaction);
        if (opcionalTransaction.isEmpty()) {
            return null;
        }
        return opcionalTransaction.get();
    }

    public Transaction createTransaction(Transaction newTransaction) {
        return this.transactionRepo.save(newTransaction);
    }

    public void deleteTransaction(Long idTransaction) {
        this.transactionRepo.deleteById(idTransaction);
    }


    public List<Transaction> getAllTransactionsByenterprise(Long idEnterprise) {
        return this.transactionRepo.findAllTransactionsByenterprise(idEnterprise);
    }

}
