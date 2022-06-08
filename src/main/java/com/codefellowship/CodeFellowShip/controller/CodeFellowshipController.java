package com.codefellowship.CodeFellowShip.controller;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class CodeFellowshipController {

    @Autowired
    CodeFellowshipRepo codeFellowshipRepo;

    // get to signup
    @GetMapping("/signup")
    public String getSignUpPage(){

        return "signup";
    }

    // get to login
//    @GetMapping("/login")
//    public String getLoginPage(){
//
//        return "login";
//    }

    // post to signup
    @PostMapping ("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String Bio){
        // hash the password
        String hashedPw; // passwordEncoder
        CodeFellowshipUser newUser = new CodeFellowshipUser(username, hashedPw, firstName, lastName, dateOfBirth, Bio);
        codeFellowshipRepo.save(newUser);

        return new RedirectView("/login");
    }

    //post to login
//    @PostMapping ("/login")
//    public RedirectView logInUser(String username, String password){
//
//
//        return new RedirectView("/");
//    }

}
