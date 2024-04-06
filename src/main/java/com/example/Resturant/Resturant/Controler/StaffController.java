package com.example.Resturant.Resturant.Controler;


import com.example.Resturant.Resturant.Entity.Staff;
import com.example.Resturant.Resturant.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Restaurant/staff")//use localhost:8080/Restaurant first of  links and  then the type the rest
public class StaffController {


    @Autowired
    private StaffRepository staffRepository;


    @GetMapping("/findAllStaffRepository")                              //find All Staffs
    public List<Staff> findAllStaffRepository(){    //return List<Staff>  ,not List<String>
        System.out.println("findByIdOfStaffRepository called");

        return staffRepository.findAll();
    }

    @GetMapping("/findStaffFirstName")                                  //find Staff First Name
    public String findStaffFirstName(@RequestBody int id){
        System.out.println("findStaffFirstName called");

        return "First name of id : " +  id + "\n First Name : \"" + staffRepository.getFirstNameById(id) + "\"";
    }

    @GetMapping("/findStaffLastName")                                   //find Staff Last Name
    public String findStaffLastName(@RequestBody int id){
        System.out.println("findStaffLastName called");

        return "Last name of id : " +  id + "\n Last Name : \"" + staffRepository.getLastNameById(id) + "\"";
    }

    @PutMapping("/deleteStaffRecordById")                              //delete Staff By Id
    public String  deleteStaffRecordById(@RequestBody long id){
        System.out.println("deleteStaffRecordById called");
        Staff staffRecord = staffRepository.findStaffRecordById(id);
        if (staffRecord == null){
            return "there is no staff by id : " + id;
        } else if (staffRecord != null) {
            staffRepository.deleteById(id);
            return staffRecord + "\ndeleted successfully";
        }
        return "exception in method deleteStaffRecordById";
    }
    @GetMapping("/doesItWork")
    public String doesGetMappingWork(){
        System.out.println("doesGetMappingWork called");
        return "yes GetMapping works";
    }
    @PostMapping("/doesPostMappingWork")
    public String doesPostMappingWork(@RequestBody String massage){
        System.out.println("doesPostMappingWork called");
        System.out.println("\"" + massage + "\" received" );

        return "we recived \"" + massage + "\"";
    }

}
