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
    
    /** be careful you should have ( cascade = CascadeType.ALL ) in the class that has @ManyToOne this test class or7
    * you should save the component and fill of that class in the=ier Repository
    * then put them in build class
    * and if you do not have cascade andif you do not have this you get error*/
    //customerRepository.save(customer1);
    /** so have ( cascade = CascadeType.ALL ) in the annotation of class and table that will contain the
     * @ManyToOne you will not get that error
     * not necessary for @OneToMany class*/

    @ManyToOne(cascade = CascadeType.ALL)           /** if you do not have this you get exception */
    @JoinColumn( name = "Customer_Id",              /** if you do not name this you will
                                                    get customer_customer_Id so name this */
                referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany                                              /** if you do not have this you get exception */
                                                            /** if you do not name this you will
                                                            get customer_customer_Id so name this */
    @JoinTable(// 6:45:0 for this tutorial
            //this annotation we need to have with colum we have in this table sowe use this pattern

            name = "Foods_On_Orders",//this table would be created

            //one of the column that we want to have to this table
            joinColumns = @JoinColumn(
                    name = "TransactionId",
                    referencedColumnName = "TransactionId"//we copy and paste the exact name from the course class field
                    //so copy paste the exact name of the field
            ),
            /** we want to have common and conversely relation between Student and course table so we need
             * this pattern : */
            inverseJoinColumns = @JoinColumn(
            name = "Foods",
            referencedColumnName = "FoodID"//we copy and paste the exact name from the Student class field
            //so copy and paste the exact name of the field
    )
    )
    private List<Food> foods;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "foods_name")
//    private List<Food> Foods;
//
//    public void adding(Food food){
//        if (food == null) {
//            this.Foods = new ArrayList<>();
//            this.Foods.add(food);
//            System.out.println("\nthis.students = new ArrayList<>();\n");
//        }
//        else{
//            this.Foods.add(food);
//            System.out.println("\nstudents.add(student);\n");
//        }
//    }

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
    //List<Food> foods = new ArrayList<>();
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
