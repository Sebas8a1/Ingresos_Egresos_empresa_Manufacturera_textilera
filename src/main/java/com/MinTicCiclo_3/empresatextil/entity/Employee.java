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
@Table(name = "employee")
public class Employee {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;

    @Getter
    @Column(name = "email", unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "idProfile")
    private Profile profile;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> transaction;

    @Getter
    @ManyToOne
    @JoinColumn(name = "idEnterprise")
    private Enterprise enterprise;


    @Getter
    @Enumerated(EnumType.STRING)
    private Enum_RolName enum_rolName;

    @Getter
    @LastModifiedDate
    private Date updateAt = new Date();
    @Getter
    @CreatedDate
    private Date createdAt = new Date();

}

