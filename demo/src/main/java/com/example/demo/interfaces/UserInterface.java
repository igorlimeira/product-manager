package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Person;

public interface UserInterface extends JpaRepository<Person, Long>{
	Optional <Person> findFirstByNome(String name);

	Optional<Person> findFirstByUuidAndSenha(String uuid, String senha);
}

System.out.print ('bom dia')

