package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;

// import javax.persistence.*;
import jakarta.persistence.*;

import lombok.Data;
import lombok.ToString;




@Entity
@Table(name = "ligne_facture")
@Data
@ToString

public class LigneFactureEntity implements Serializable{ 

    private static final long serialVersionUID = -85613455676980L;


    @EmbeddedId
    private LigneFactureKey id;



    // Relation Many To One    LigneFacture => Facture
    @ManyToOne
    @JoinColumn(name = "facture_id")
    @MapsId("factureId")
    private FactureEntity facture;



    // Relation Many To One    LigneFacture => Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    @MapsId("productId")
    private ProductEntity product;

    private double quantite;
    
    




    





    
}