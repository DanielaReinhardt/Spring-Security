package com.wildcodeschool.myProjectWithSecurity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Controller {
    
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the SHIELD" ;
    }

    @GetMapping("/avengers/assemble")
    public String admin() {
        return "Avengers..... Assemble";
    }

    @GetMapping("/secret-bases")
    public String user() {
        return "List of cities: <br> Amsterdam <br>Barcelona <br> Berlin<br> Bruxelles<br> Bucarest<br> Lisbonne<br> Londres<br> Madrid"; 
    }

    
    
}
