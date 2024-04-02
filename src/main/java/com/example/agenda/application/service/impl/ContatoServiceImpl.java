package com.example.agenda.application.service.impl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agenda.application.api.model.ContatoRequest;
import com.example.agenda.application.api.model.ContatoResponse;
import com.example.agenda.application.repository.ContatoRepository;
import com.example.agenda.application.service.ContatoService;
import com.example.agenda.domain.Contato;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Slf4j
public class ContatoServiceImpl implements ContatoService {
    @Autowired
    private ContatoRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addContato(ContatoRequest contatoRequest) {
        log.info("Starting ContatoServiceImpl - addContato");
        Contato contato = mapper.map(contatoRequest, Contato.class);
        repository.save(contato);

    }

    @Override
    public List<ContatoResponse> buscaContatos(String nome) {
        log.info("Starting ContatoServiceImpl - buscaContatos");
        List<Contato> lista = Objects.nonNull(nome) ? buscaTodosContatos(nome) : buscaTodosContatos();
        return mapper.map(lista, new TypeToken<List<ContatoResponse>>() {
        }.getType());
    }

    private List<Contato> buscaTodosContatos() {
        log.info("Starting ContatoServiceImpl - buscaTodosContatos");
        return repository.findAll();
    }

    private List<Contato> buscaTodosContatos(String nome) {
        log.info("Starting ContatoServiceImpl -  buscaTodosContatos({})", nome);
        return repository.findByNomeIsStartingWithIgnoringCase(nome);

    }

    @Override
    public ContatoResponse buscaContatoPorId(Integer id) {

        log.info("Starting ContatoServiceImpl -  buscaContatoPorId({})", id);
        Contato contatoBuscado = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id Contato ínvalido!!!"));
        return mapper.map(contatoBuscado, ContatoResponse.class);

    }

    @Override
    public void deletaContato(Integer id) {
        log.info("Starting ContatoServiceImpl - deletaContato");
        buscaContatoPorId(id);
        repository.deleteById(id);
    }

    @Override
    public void atualizaContato(Integer id, ContatoRequest contato) {
        log.info("Starting ContatoServiceImpl - atualizaContato");
        ContatoResponse contatoEncontrado = buscaContatoPorId(id);
        contatoEncontrado.setNome(contato.getNome());
        contatoEncontrado.setTelefone(contato.getTelefone());

        repository.save(mapper.map(contatoEncontrado, Contato.class));
    }

}