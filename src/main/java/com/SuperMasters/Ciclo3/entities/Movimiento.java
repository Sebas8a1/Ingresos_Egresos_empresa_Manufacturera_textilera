package com.SuperMasters.Ciclo3.entities;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "movimiento")
@NoArgsConstructor @ToString @AllArgsConstructor
public class Movimiento {

	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter @Setter
	@Column(name = "monto", length = 50, nullable = false)
	private float monto;

	@Getter @Setter
	@Column(name = "concepto", length = 50, nullable = false)
	private String concepto;

	@Getter @Setter
	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;



	@LastModifiedDate @Setter @Getter
	private Date updateAt = new Date();
	@CreatedDate @Setter @Getter
	private Date createdAt = new Date();
}
