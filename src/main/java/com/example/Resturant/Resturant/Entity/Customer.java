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
        name = "Customer"
//        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
//                name = "emailId_unique",
//                columnNames = "email_Address"//the name of the column the real one
//        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE
@SequenceGenerator(name = "a1_seq", sequenceName = "a1_seq", allocationSize    = 1)
@SequenceGenerator(name = "b1_seq", sequenceName = "b1_seq", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class Customer {

    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Customer_Id_sequence",
            sequenceName = "Customer_Id_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Customer_Id_sequence"
    )
    private Long customerId;
    private String firstName;
    private String LastName;

    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Customer_phone_Number_sequence",
            sequenceName = "Customer_phone_Number_sequence",
            allocationSize = 53,
            initialValue = 253658
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Customer_phone_Number_sequence"
    )
    private String phoneNumber;
    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "postal_Code_sequence",
            sequenceName = "postal_Code_sequence",
            allocationSize = 152,
            initialValue = 32658
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "postal_Code_sequence"
    )
    private String postal_Code;
    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "customer_subscription_Code_sequence",
            sequenceName = "customer_subscription_Code_sequence",
            allocationSize = 32,
            initialValue = 1236
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "customer_subscription_Code_sequence"
    )
    private String subscription_Code;

//    @ManyToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(// 6:45:0 for this tutorial
//            //this annotation we need to have with colum we have in this table sowe use this pattern
//
//            name = "customer_transaction",//this table would be created
//
//            //one of the column that we want to have to this table from this class
//            joinColumns = @JoinColumn(
//                    name = "customer_name",
//                    referencedColumnName = "customerId"       //we copy and paste the exact name from the course class field
//                    //so copy paste the exact name of the field
//            ),
//
//            /** we want to have common and conversely relation between Student and course table so we need
//             * this pattern : */
//            inverseJoinColumns = @JoinColumn(
//                    name = "transaction",
//                    referencedColumnName = "name"//we copy and paste the exact name from the Student class field
//                    //so copy and paste the exact name of the field
//            )
//    )
//    List<Transaction> transactions = new ArrayList<>();
//
//
//    public void addTransactions(Transaction transaction){
//        //we add this method becuase we have @ManyToMany in field for students
//
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


}