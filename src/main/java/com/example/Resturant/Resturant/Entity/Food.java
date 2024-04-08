package com.example.Resturant.Resturant.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "Food",
               uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
                        name = "Foods_unique",
                columnNames = "Foods_name"//the name of the column the real one
        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder

public class Food {
    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Food_sequence",
            sequenceName = "Food_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Food_sequence"
    )
    private Long FoodID;

    private String FoodsName;


    private long price;                     //kg or litre
    private long amount;


//    /** bug */
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "FoodsName",                 // if you change this the previous column does not delete
//            referencedColumnName = "FoodID")        // and the new column will add by this name
//    private List<Transaction> transactions;


//    public void adding(Transaction transaction){
//        if (transactions == null) {
//            this.transactions = new ArrayList<>();
//            this.transactions.add(transaction);
//            System.out.println("\nthis.students = new ArrayList<>();\n");
//        }
//        else{
//            this.transactions.add(transaction);
//            System.out.println("\nstudents.add(student);\n");
//        }
//    }
//    @ManyToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(// 6:45:0 for this tutorial
//            //this annotation we need to have with colum we have in this table sowe use this pattern
//
//            name = "food_ingredients",                  //this table would be created
//
//            //one of the column that we want to have to this table from this class
//            joinColumns = @JoinColumn(
//                    name = "food_name",
//                    referencedColumnName = "FoodsName"       //we copy and paste the exact name from the course class field
//                                                        //so copy paste the exact name of the field
//            ),
//
//            /** we want to have common and conversely relation between Student and course table so we need
//             * this pattern : */
//            inverseJoinColumns = @JoinColumn(
//                    name = "Ingredient_name",
//                    referencedColumnName = "name"       //we copy and paste the exact name from the Student class field
//                                                        //so copy and paste the exact name of the field
//            )
//    )
//    List<Ingredient> ingredients = new ArrayList<>();
//
//    public void addIngredient(Ingredient ingredient){
//        //we add this method becuase we have @ManyToMany in field for students
//
//        if (ingredient == null) {
//            this.ingredients = new ArrayList<>();
//            this.ingredients.add(ingredient);
//            System.out.println("\nthis.students = new ArrayList<>();\n");
//        }
//        else{
//            this.ingredients.add(ingredient);
//            System.out.println("\nstudents.add(student);\n");
//        }
//    }
}
