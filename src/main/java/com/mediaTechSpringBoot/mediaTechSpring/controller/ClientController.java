package com.mediaTechSpringBoot.mediaTechSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public List<ClientResponseDto> getAllClients() {
        return clientService.findAll();
    }




    @PostMapping("")
    public ClientResponseDto saveClient(@RequestBody() ClientRequestDto ClientRequestDto) {
        return clientService.saveClient(ClientRequestDto);
    }

    // get Client By Id :  http://localhost:8080/clients/id/1
    @GetMapping("/id/{id}")
    public ClientResponseDto getClientById(@PathVariable("id") Integer id) {
        return clientService.getClientById(id);
    }

    // Get Client By Nom :  http://localhost:8080/clients/nom/ahmed
    @GetMapping("/nom/{nom}")
    public ClientResponseDto getClientByNom(@PathVariable("nom") String nom) {
        return clientService.getClientByNom(nom);
    }

    // Update Client By Id :  http://localhost:8080/clients/id/1
    @PutMapping("/id/{id}")
    public ClientResponseDto updateClient(@RequestBody() ClientRequestDto clientRequestDto, @PathVariable("id") Integer id) {
        return clientService.updateClient(clientRequestDto, id);
    }


    // Delete Client By Id :  http://localhost:8080/clients/id/1
    @DeleteMapping("/id/{id}")
    public void deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClient(id);
    }
    
    
    




}
