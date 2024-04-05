package com.example.Resturant.Resturant.Repository;

import com.example.Resturant.Resturant.Entity.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StaffRepositoryTest {

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void saveStaffDefaultMethod(){
        Staff staff1 = Staff.builder()
                .firstName("c")
                .lastName("cc")
                .build();
        Staff staff2 = Staff.builder()
                .firstName("d")
                .lastName("dd")
                .build();
        Staff staff3 = Staff.builder()
                .firstName("e")
                .lastName("ee")
                .build();

        staffRepository.save(staff1);
        staffRepository.save(staff2);
        staffRepository.save(staff3);

        System.out.println("\n");
        System.out.println("staff : " + staff1 + staff2 + staff3 + "\nAdded");
        System.out.println("\n");

    }
    @Test
    public void getFirstNameById(){

        System.out.println("*******\n");
        System.out.println("staffs : " + staffRepository.findAll());
        System.out.println("*******\n");

    }
}