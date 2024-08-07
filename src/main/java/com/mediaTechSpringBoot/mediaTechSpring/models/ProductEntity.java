package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
// import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity  implements Serializable{


   private static final long serialVersionUID = -85613455676980L;

    @Id()
    private Integer id;
    

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private String libelle;

 
    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false)
    private double quantite_stock;



    // Relation One To Many    Product => LigneFacture
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> ligneFacture;
    
    
}