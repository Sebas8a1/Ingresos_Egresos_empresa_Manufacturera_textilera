package com.MinTicCiclo_3.empresatextil.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnterprise;



    @Getter
    @Column(name = "name", unique = true)
    private String name;


    @Getter
    @Column(name = "document", unique = true)
    private String document;

    @Getter
    private String phone;

    @Getter
    private String address;


    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employee;

    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transaction;

    @Getter
    @LastModifiedDate
    private Date updateAt = new Date();
    @Getter
    @CreatedDate
    private Date createdAt = new Date();


}

