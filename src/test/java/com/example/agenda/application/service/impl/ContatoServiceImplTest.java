// package com.example.agenda.application.service.impl;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.example.agenda.application.repository.ContatoRepository;
// import com.example.agenda.domain.Contato;

// @ExtendWith(MockitoExtension.class)
// public class ContatoServiceImplTest {

//     @InjectMocks
//     ContatoServiceImpl service;

//     @Mock
//     ContatoRepository repository;

//     @Test
//     void deveRetornarContatoCriadoComSucesso(){

//       //DADO 
//        Contato novoContato = getMockContato();
//        //QUANDO
//        when(repository.addContato(any())).thenReturn(getMockContato());

//         //ENTÃO
//        String response = service.addContato(novoContato);


       
//        assertEquals(String.class, response.getClass());
//        assertNotNull(response);
       
//     }


//     private Contato getMockContato(){
//         return Contato.builder()
//                         .nome("nome")
//                         .id(1)
//                         .email("email@email.com")
//                         .telefones( List.of("55 5555 5555"))
//                         .build();
//     }
    
// }
