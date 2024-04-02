package com.example.agenda.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.application.api.AgendaApi;
import com.example.agenda.application.api.model.ContatoRequest;
import com.example.agenda.application.api.model.ContatoResponse;
import com.example.agenda.application.service.ContatoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class ContatoController implements AgendaApi {

	private ContatoService contatoService;

	@Override
	public void postContato(ContatoRequest contatoRequest) {
		log.info("Starting ContatoController - postContato ");
		contatoService.addContato(contatoRequest);

	}

	@Override
	public ContatoResponse getContato(Integer id) {
		log.info("Starting ContatoController - getContato");
		return contatoService.buscaContatoPorId(id);
	}

	@Override
	public List<ContatoResponse> getListContato(String nome) {
		log.info("Starting ContatoController - getListContato");
		return contatoService.buscaContatos(nome);
	}

	@Override
	public void patchContato(Integer id, ContatoRequest contato) {
		log.info("Starting ContatoController - patchContato");
		contatoService.atualizaContato(id, contato);
	}

	@Override
	public void deleteContato(Integer id) {
		log.info("Starting ContatoController - deleteContato");
		contatoService.deletaContato(id);
	}

}
