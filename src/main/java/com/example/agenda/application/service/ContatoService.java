package com.example.agenda.application.service;

import java.util.List;
import com.example.agenda.application.api.model.ContatoRequest;
import com.example.agenda.application.api.model.ContatoResponse;

public interface ContatoService {

    void addContato(ContatoRequest contato);

    List<ContatoResponse> buscaContatos(String nome);

    ContatoResponse buscaContatoPorId(Integer idContato);

    void deletaContato(Integer idContato);

    void atualizaContato(Integer id, ContatoRequest contato);

}
