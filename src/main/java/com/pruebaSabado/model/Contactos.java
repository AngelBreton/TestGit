package com.pruebaSabado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contactos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //genera Id Incremental
	 Integer idContacto;
	
	@Column
	 String nombre;
	
	@Column
	 String email;
	
	@Column
	 int edad;

	

}
