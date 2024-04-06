package com.example.Resturant.Resturant.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "Ingredients"
//        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
//                name = "emailId_unique",
//                columnNames = "email_Address"//the name of the column the real one
//        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class Ingredient {


    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Ingredient_sequence",
            sequenceName = "Ingredient_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Ingredient_sequence"
    )
    private Long ingredientID;
    private long amount;
    private String name;
    private String unit;      //kg or litre
    private long pricePerUnit;


}

