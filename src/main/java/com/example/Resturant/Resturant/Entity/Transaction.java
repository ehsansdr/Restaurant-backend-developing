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
        name = "Transactions"
//        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
//                name = "emailId_unique",
//                columnNames = "email_Address"//the name of the column the real one
//        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class Transaction {
    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Transaction_sequence",
            sequenceName = "Transaction_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Transaction_sequence"
    )
    private Long TransactionId;
    private String customerID;

//    @OneToMany(//uni directional on to
//        cascade = CascadeType.ALL  //when ever you are saving new record
//            // all the things save
//            //fetch = FetchType.LAZY  //be careful about this
//    )
//    @JoinColumn(//if you want to link to secrete table to rwo column do this
//            name = "Transactions",//
//            referencedColumnName = "TransactionId"         //another table column
//                                                        //if you clicked on this column you will get to the Food record to another
//                                                        // and the column in this
//                                                        // table will get value from upper column from beneath table
//    )

    /** bug we can not add this to table*/
    List<Food> foods = new ArrayList<>();
//
//
//    public void addStudent(Food food){
//        //we add this method becuase we have @ManyToMany in field for students
//
//        if (foods == null) {
//            this.foods = new ArrayList<>();
//            this.foods.add(food);
//            System.out.println("\nthis.students = new ArrayList<>();\n");
//        }
//        else{
//            this.foods.add(food);
//            System.out.println("\nstudents.add(student);\n");
//        }
//    }

}
