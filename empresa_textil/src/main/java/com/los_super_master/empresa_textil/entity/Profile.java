package com.los_super_master.empresa_textil.entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
public class Profile {

    @Id
    private long id;
}
