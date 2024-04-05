package com.example.Resturant.Resturant.Controler;


import com.example.Resturant.Resturant.Entity.Staff;
import com.example.Resturant.Resturant.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Restaurant")//use localhost:8080/Restaurant first of  links and  then the type the rest
public class Controller {


    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/doesItWork")
    public String doesGetMappingWork(){
        System.out.println("doesGetMappingWork called");
        return "yes GetMapping works";
    }

    @GetMapping("/findAllStaffRepository")
    public List<Staff> findAllStaffRepository(){    //return List<Staff>  ,not List<String>
        System.out.println("findByIdOfStaffRepository called");

        return staffRepository.findAll();
    }

    @GetMapping("/findStaffFirstName")
    public String findStaffFirstName(@RequestBody int id){
        System.out.println("findStaffFirstName called");

        return "First name of id : " +  id + " is \"" + staffRepository.getFirstNameById(id) + "\"";
    }

    @GetMapping("/findStaffLastName")
    public String findStaffLastName(@RequestBody int id){
        System.out.println("findStaffLastName called");

        return "Last name of id : " +  id + " is \"" + staffRepository.getLastNameById(id) + "\"";
    }

    @PostMapping("/doesPostMappingWork")
    public String doesPostMappingWork(@RequestBody String massage){
        System.out.println("doesPostMappingWork called");
        System.out.println("\"" + massage + "\" received" );

        return "we recived \"" + massage + "\"";


    }

}
