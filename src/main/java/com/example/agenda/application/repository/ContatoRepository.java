package com.example.agenda.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.domain.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer>{

    List<Contato> findByNomeIsStartingWithIgnoringCase(String nome);
   
}
