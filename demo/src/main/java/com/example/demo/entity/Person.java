package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "user_first_name")
	@JsonProperty("user_first_name")
	private String nome;
	
	@Column(name = "user_last_name")
	@JsonProperty("user_last_name")
	private String sobreNome;
	
	@Column(name = "user_cpf")
	@JsonProperty("user_cpf")
	private String cpf;
	
	@Column(name = "uuid")
	@JsonProperty("uuid")
	private String uuid;
	
	@Column(name="passphrase")
	@JsonProperty("passphrase")
	private String senha;
}
