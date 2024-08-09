package com.mediaTechSpringBoot.mediaTechSpring.services;

import java.util.List;

import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientRequestDto;
import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientResponseDto;

public interface ClientServices {


    ClientResponseDto  saveClient(ClientRequestDto clientRequestDto);

    ClientResponseDto  getClientById(Integer id);

    ClientResponseDto  getClientByNom(String nom);

    void  deleteClient(Integer id);

    ClientResponseDto  updateClient(ClientRequestDto clientRequestDto, Integer id);

  
    public List<ClientResponseDto> findAll();

}
