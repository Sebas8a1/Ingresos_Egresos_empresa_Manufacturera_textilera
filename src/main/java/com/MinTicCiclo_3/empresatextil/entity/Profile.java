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

/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProfile;

    private String image;
    private String phone;

    @OneToOne(mappedBy = "profile")
    private Employee employee;

    @LastModifiedDate
    private Date updateAt = new Date();
    @CreatedDate
    private Date createdAt = new Date();


}

