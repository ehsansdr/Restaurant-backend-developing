package com.example.Resturant.Resturant.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@SequenceGenerator(name = "a1_seq", sequenceName = "a1_seq", allocationSize = 1)
//@SequenceGenerator(name = "b1_seq", sequenceName = "b1_seq", allocationSize = 1)

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

    @Column(nullable = false,
            unique = true)
    private String firstName;

    @Column(nullable = false,
            unique = true)
    private String LastName;

    /** we have bug here if we un commit this we get bean creation exception because of
     * multiple sequence*/
    @Column(nullable = false)
    private String phoneNumber;


    private String postal_Code;

    @Column(nullable = false,
            unique = true)
    private String subscription_Code;




    /** you will not see this column  in this class table ,
     * you see this to the table or class that you have the type (in this case you see ths in "Transaction" )
     * be careful, if here you have @OneToMany ,it should have @ManyToOne on this class type ("Customer") in the that type class
     * (in this case you should have @ManyToOne in "Transaction" class )
     * and have real and same referencedColumnName = "(field name ,not that column name that shows for column in database,the java class name)"
     * the column will go to the table that has @ManyToOne annotation ,not the clas that has @oneToMany*/

    /** be careful you should have ( cascade = CascadeType.ALL ) in the class that has @ManyToOne this test class or7
     * you should save the component and fill of that class in the=ier Repository
     * then put them in build class
     * and if you do not have cascade andif you do not have this you get error*/
    //customerRepository.save(customer1);
    /** so have ( cascade = CascadeType.ALL ) in the annotation of class and table that will contain the
     * @ManyToOne you will not get that error
     * not necessary for @OneToMany class*/






    @OneToMany( cascade = CascadeType.ALL,
            mappedBy = "customer")                      // it try to find the object that has name to neneath class data type so  be careful about letters and write exactly the same
    @JsonManagedReference                               // @JsonManagedReference is the forward part of reference – the one that gets serialized normally.
    private List<Transaction> transactions;             // @JsonBackReference is the back part of reference – it will be omitted from serialization.
                                                        // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
                                                        // https://stackoverflow.com/questions/72794421/what-is-the-meaning-of-jsonmanagedreference


                                                        // if you change this ,the previous column does not delete and the new column will add by this name
                                                        // be careful have this name = "Customer_Id"  to the field type class
                                                        // if not you get to column that have same rfrenxce and trash and spam
                                                        // if you want to reference that column has this in its calls
                                                        // in the class you have @OneToMany and have this reference to that class
                                                        // and have this referencedColumnName = "customerId") exactly
                                                        // no mather that class (the below type object)has this field


    public void adding(Transaction transaction){
        if (transactions == null) {
            this.transactions = new ArrayList<>();
            this.transactions.add(transaction);
            System.out.println("\nthis.students = new ArrayList<>();\n");
        }
        else{
            this.transactions.add(transaction);
            System.out.println("\nstudents.add(student);\n");
        }
    }


//    @Id
//    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
//            name = "postal_Code_sequence",
//            sequenceName = "postal_Code_sequence",
//            allocationSize = 152,
//            initialValue = 32658
//    )
//    //using created sequence
//    @GeneratedValue(
//            strategy =  GenerationType.SEQUENCE,
//            generator = "postal_Code_sequence"
//    )
//    @ManyToMany(
//            cascade = CascadeType.ALL
//    )
//    @JoinTable(// 6:45:0 for this tutorial
//            //this annotation we need to have with colum we have in this table sowe use this pattern
//
//            name = "customer_transactions",                     //this table would be created
//
//            //one of the column that we want to have to this table from this class
//            joinColumns = @JoinColumn(
//                    name = "customer_name",
//                    referencedColumnName = "customerId"         //we copy and paste the exact name from the course class field
//                                                                //so copy paste the exact name of the field
//            ),
//
//            /** we want to have common and conversely relation between Student and course table so we need
//             * this pattern : */
//            inverseJoinColumns = @JoinColumn(
//                    name = "transactions",
//                    referencedColumnName = "name"               //we copy and paste the exact name from the Student class field
//                                                                //so copy and paste the exact name of the field
//            )
//    )
    //List<Transaction> transactions = new ArrayList<>();


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

//    @Id//if you want multiple sequence , make sure have @Id for each new @SequenceGenerator
//    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
//            name = "Customer_phone_Number_sequence",
//            sequenceName = "Customer_phone_Number_sequence",
//            allocationSize = 53,
//            initialValue = 253658
//    )
//    //using created sequence
//    @GeneratedValue(
//            strategy =  GenerationType.SEQUENCE,
//            generator = "Customer_phone_Number_sequence"
//    )//    @Id
////    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
////            name = "customer_subscription_Code_sequence",
////            sequenceName = "customer_subscription_Code_sequence",
////            allocationSize = 32,
////            initialValue = 1236
////    )
////    //using created sequence
////    @GeneratedValue(
////            strategy =  GenerationType.SEQUENCE,
////            generator = "customer_subscription_Code_sequence"
////    )
}
