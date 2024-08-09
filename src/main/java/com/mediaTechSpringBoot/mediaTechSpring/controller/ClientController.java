package com.mediaTechSpringBoot.mediaTechSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientRequestDto;
import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientResponseDto;
import com.mediaTechSpringBoot.mediaTechSpring.services.ClientServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    @Qualifier("impl1")
    private  ClientServices clientService;


    public ClientController(ClientServices clientService) {
        this.clientService = clientService;
    }


   
    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>>  getAllClients() {
        return new ResponseEntity<List<ClientResponseDto>>(clientService.findAll(), HttpStatus.OK);
    }




    @PostMapping("")
    public ResponseEntity<ClientResponseDto> saveClient(@RequestBody() ClientRequestDto ClientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.saveClient(ClientRequestDto);
        return new ResponseEntity<ClientResponseDto>(clientResponseDto, HttpStatus.CREATED);

    }

    // get Client By Id :  http://localhost:8080/clients/id/1
    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto = clientService.getClientById(id);
        return ResponseEntity.ok(clientResponseDto);
    }

    // Get Client By Nom :  http://localhost:8080/clients/nom/ahmed
    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> getClientByNom(@PathVariable("nom") String nom) {
        ClientResponseDto clientResponseDto = clientService.getClientByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }

    // Update Client By Id :  http://localhost:8080/clients/id/1
    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> updateClient(@RequestBody() ClientRequestDto clientRequestDto, @PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto = clientService.updateClient(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }


    // Delete Client By Id :  http://localhost:8080/clients/id/1
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
    
    
    




}
