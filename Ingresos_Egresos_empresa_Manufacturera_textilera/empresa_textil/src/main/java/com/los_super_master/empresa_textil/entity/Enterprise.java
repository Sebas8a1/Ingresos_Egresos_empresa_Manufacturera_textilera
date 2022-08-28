package com.los_super_master.empresa_textil.entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnterprise;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employee;

    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transaction;

    @LastModifiedDate
    private Date updateAt;
    @CreatedDate
    private Date createdAt;

    public Enterprise() {

    }

    public Enterprise(long idEnterprise, String name, String document, String phone, String address, List<Employee> employee, List<Transaction> transaction, Date updateAt, Date createdAt) {
        this.idEnterprise = idEnterprise;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.employee = employee;
        this.transaction = transaction;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
