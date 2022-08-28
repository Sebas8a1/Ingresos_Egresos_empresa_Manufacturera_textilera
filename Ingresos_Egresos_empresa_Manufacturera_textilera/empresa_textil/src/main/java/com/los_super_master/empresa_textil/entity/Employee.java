package com.los_super_master.empresa_textil.entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.persistence.Table;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne
    @JoinColumn (name = "idProfile")
    private Profile profile;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> transaction;

    @ManyToOne
    @JoinColumn(name = "idEnterprise")
    private Enterprise enterprise;

    @Enumerated (EnumType.STRING)
    private Enum_RolName enum_rolName;

    @LastModifiedDate
    private Date updateAt;
    @CreatedDate
    private Date createdAt;

    public Employee(){

    }

    public Employee(long idEmployee, String email, Profile profile, List<Transaction> transaction, Enterprise enterprise, Enum_RolName enum_rolName, Date updateAt, Date createdAt) {
        this.idEmployee = idEmployee;
        this.email = email;
        this.profile = profile;
        this.transaction = transaction;
        this.enterprise = enterprise;
        this.enum_rolName = enum_rolName;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enum_RolName getEnum_rolName() {
        return enum_rolName;
    }

    public void setEnum_rolName(Enum_RolName enum_rolName) {
        this.enum_rolName = enum_rolName;
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
