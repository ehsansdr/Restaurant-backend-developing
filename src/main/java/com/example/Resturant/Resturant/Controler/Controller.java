package com.example.Resturant.Resturant.Controler;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Restaurant")//use localhost:8080/Restaurant first of  links and  then the type the rest
public class Controller {

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
