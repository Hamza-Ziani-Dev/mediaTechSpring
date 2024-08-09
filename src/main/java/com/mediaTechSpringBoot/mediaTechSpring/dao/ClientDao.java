package com.mediaTechSpringBoot.mediaTechSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediaTechSpringBoot.mediaTechSpring.models.ClientEntity;



@Repository
public interface ClientDao  extends JpaRepository<ClientEntity, Integer>{

    ClientEntity findByNom(String nom);

}
