package com.mediaTechSpringBoot.mediaTechSpring.models;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Column;


import java.io.Serializable;
import java.util.List;

// import javax.persistence.*;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "clients")
public class ClientEntity implements Serializable {
	
	
	
	@Id()
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@Column(name = "client_telephone")
	private String telephone;



	// Relation One To Many    Client => Facture
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<FactureEntity> factures;
	
	

}
