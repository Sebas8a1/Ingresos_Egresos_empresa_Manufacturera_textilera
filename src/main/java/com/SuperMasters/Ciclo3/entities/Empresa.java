package com.SuperMasters.Ciclo3.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor @ToString @AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "empresa")
public class Empresa {

	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter @Setter
	@Column(name = "nombre", length = 50, nullable = false, unique = true)
	private String nombre;
	@Getter @Setter
	@Column(name = "direccion", length = 150, nullable = false)
	private String direccion;
	@Getter @Setter
	@Column(name = "telefono", length = 50, nullable = false)
	private String telefono;
	@Getter @Setter
	@Column(name = "nit", length = 50, nullable = false)
	private String nit;

	@Getter @Setter
	@LastModifiedDate
	private Date updateAt = new Date();
	@Getter @Setter
	@CreationTimestamp
	@CreatedDate
	private Date createdAt = new Date();



}
