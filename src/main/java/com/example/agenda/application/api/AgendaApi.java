package com.example.agenda.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.agenda.application.api.model.ContatoRequest;
import com.example.agenda.application.api.model.ContatoResponse;

@RequestMapping("/agenda/api/v1/contato")
public interface AgendaApi {

    @PostMapping  
    @ResponseStatus(code = HttpStatus.CREATED)
    public void postContato(@RequestBody ContatoRequest contato);


    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ContatoResponse getContato(@PathVariable Integer id );

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ContatoResponse> getListContato(@RequestParam(required = false) String nome );


    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void patchContato(@PathVariable Integer id ,@RequestBody ContatoRequest contato);


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteContato(@PathVariable Integer id );

}
