package com.mediaTechSpringBoot.mediaTechSpring.models;

import java.io.Serializable;

// import javax.persistence.*;
import jakarta.persistence.*;



@Embeddable
public class LigneFactureKey implements Serializable {


    private static final long serialVersionUID = -85613455676980L;


    @Column(name = "facture_id")
    private Integer factureId;



    @Column(name = "product_id")
    private Integer productId;
    
   
}