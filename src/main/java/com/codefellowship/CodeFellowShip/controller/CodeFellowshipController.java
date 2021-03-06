package com.codefellowship.CodeFellowShip.controller;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import com.codefellowship.CodeFellowShip.model.Post;
import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Controller
public class CodeFellowshipController {

    @Autowired
    CodeFellowshipRepo codeFellowshipRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    // get to signup
    @GetMapping("/signup")
    public String getSignUpPage(){

        return "signup";
    }

//     get to login
    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }


//    @GetMapping("/myprofile")
//        public String getMyProfile(Principal p, Model m){
//        if(p != null){
//            String username = p.getName();
//            CodeFellowshipUser user = codeFellowshipRepo.findByUsername(username);
//            List<Post> postList = user.getUserPosts();
//
//            m.addAttribute("user", user);
//            m.addAttribute("posts",postList);
//        }
//
//
//        return "myProfile";
//    }



//    @GetMapping("/home")
//    public String getHomePage(){
//
//        return "home";
//    }

    // post to signup
    @PostMapping ("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio){
        // hash the password
        String hashedPw = passwordEncoder.encode(password);
        CodeFellowshipUser newUser = new CodeFellowshipUser(username, hashedPw, firstName, lastName, dateOfBirth, bio);
        codeFellowshipRepo.save(newUser);

        authWithHttpServletRequest(username, password);

        return new RedirectView("/home");
    }

    public void authWithHttpServletRequest(String username, String password){

        try{
            request.login(username, password);
        } catch (ServletException e) {
            System.out.println("Error while logging in.");
            e.printStackTrace();
        }
    }



////    post to login
    @PostMapping ("/login")
    public RedirectView logInUser(String username, String password){


        return new RedirectView("/home");
    }

}
