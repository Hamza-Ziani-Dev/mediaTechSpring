package com.mediaTechSpringBoot.mediaTechSpring.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mediaTechSpringBoot.mediaTechSpring.dao.ClientDao;
import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientRequestDto;
import com.mediaTechSpringBoot.mediaTechSpring.dto.ClientResponseDto;
import com.mediaTechSpringBoot.mediaTechSpring.models.ClientEntity;

@Service("impl1")
public class ClientServiceImp implements ClientServices{
    
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImp(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }


    

    @Override
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
        
    }

    @Override
    public ClientResponseDto getClientById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto getClientByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void deleteClient(Integer id) {
        clientDao.deleteById(id);

    }

    @Override
    public ClientResponseDto updateClient(ClientRequestDto clientRequestDto, Integer id) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        clientEntity.setId(id);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }




    @Override
    public List<ClientResponseDto> findAll() {
      return clientDao.findAll()
      .stream().map(el -> modelMapper
      .map(el, ClientResponseDto.class))
      .toList();
    }




  
}
