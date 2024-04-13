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
        name = "orderList",
        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
                name = "Foods_unique",
                columnNames = "Foods_name"//the name of the column the real one
        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class ListOfOrders {

    @Id
    private Long foodId;
//    @OneToOne
//    @JoinColumn(
//            name = "foodList",
//            referencedColumnName = ""
//    )
    //private List<Food> foodList;

//    public void addAddingFood(Food food){
////we add this method becuase we have @ManyToMany in field for students
//
//        if (foodList == null) {
//            this.foodList = new ArrayList<>();
//            foodList.add(food);
//            System.out.println("\nthis.students = new ArrayList<>();\n");
//        }
//        else{
//            foodList.add(food);
//            System.out.println("\nstudents.add(student);\n");
//        }
//    }

}
