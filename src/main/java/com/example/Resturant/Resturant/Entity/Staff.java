package com.example.Resturant.Resturant.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "Staff"
//        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
//                name = "emailId_unique",
//                columnNames = "email_Address"//the name of the column the real one
//        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE


@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
/**  don't forget this  */
public class Staff {
    //https://www.baeldung.com/hibernate-identifiers
    @Id
    //how we can use sequence for generating automatically fo MYSQL (NOT ORACLE OR POSTGRES)
    //generating but not using that
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "Staff_id_sequence",
            sequenceName = "Staff_id_sequence", //If we don’t specify a sequence name,
                                                // Hibernate will reuse the same hibernate_sequence for different types.
            allocationSize = 1,
            initialValue = 100//the least value that entity can have and start from that
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,//AUTO, IDENTITY, SEQUENCE and TABLE
                                                //the generation type defaults to AUTO.
            generator = "Staff_id_sequence" //If we don’t specify a sequence name,
                                            // Hibernate will reuse the same hibernate_sequence for different types.

    )
    private Long StaffId;//UUID instead of Long will generate an id of the form “8dd5f315-9788-4d00-87bb-10eed9eff566”.
    private String firstName;
    private String lastName;
    /** automatically database change the format from camel to last_name */
}
