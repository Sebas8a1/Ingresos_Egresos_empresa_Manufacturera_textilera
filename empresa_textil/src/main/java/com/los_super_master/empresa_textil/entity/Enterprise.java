package com.los_super_master.empresa_textil.entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
public class Enterprise {

    @Id
    private long id;

    @OneToMany
    private Employee employee;
}
