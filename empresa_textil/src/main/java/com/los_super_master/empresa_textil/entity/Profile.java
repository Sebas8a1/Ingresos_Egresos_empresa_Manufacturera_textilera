package com.los_super_master.empresa_textil.entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProfile;

    private String image;
    private String phone ;

    @OneToOne (mappedBy = "profile")
    private Employee employee;

    @LastModifiedDate
    private Date updateAt;
    @CreatedDate
    private Date createdAt;

    public Profile(){

    }

    public Profile(long idProfile, String image, String phone, Employee employee, Date updateAt, Date createdAt) {
        this.idProfile = idProfile;
        this.image = image;
        this.phone = phone;
        this.employee = employee;
        this.updateAt = updateAt;
        this.createdAt = createdAt;
    }

    public long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(long idProfile) {
        this.idProfile = idProfile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
