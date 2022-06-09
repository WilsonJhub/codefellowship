//package com.codefellowship.CodeFellowShip.controller;
//
//
//import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
//import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.servlet.view.RedirectView;
//
//import java.lang.module.ResolutionException;
//import java.security.Principal;
//import java.time.LocalDateTime;
//
//// In HomeController, this is where we host new routes with all of our relevant data.
//@Controller
//public class HomeController {
//
//    // bring in repo
//    @Autowired
//    CodeFellowshipRepo codeFellowshipRepo;
//
//    @GetMapping("/home")
//    public String getHomePage(Principal p, Model m){
//
//        if (p != null){
//            String username = p.getName();
//            CodeFellowshipUser appUser = codeFellowshipRepo.findByUsername(username);
//
//            m.addAttribute("username", username);
//        }
//        return "home";
//    }
//
//    @GetMapping("/test")
//    // What is Principal? -> It is the Authenticated User.
//    public String getTestPage(Principal p, Model m){
//
//        if (p != null){
//            String username = p.getName();
//            CodeFellowshipUser appUser = codeFellowshipRepo.findByUsername(username);
//
//            m.addAttribute("username", username);
//        }
//        return "test";
//    }
//
//    // /user/
//    @GetMapping("/users/{id}")
//    public String getUserInfo(Principal p, Model m, @PathVariable Long id){
//        // This is session info
//        if (p != null){ // not strictly required if your WebSecurityConfig is correct
//            String username = p.getName();
//            CodeFellowshipUser appUser = codeFellowshipRepo.findByUsername(username);
//
//            m.addAttribute("username", username); // authenticated username
//        }
//        // DataBase call to get user info
//        CodeFellowshipUser appUser = codeFellowshipRepo.findById(id).orElseThrow();
//        m.addAttribute("appUsername", appUser.getUsername()); // database username
//        m.addAttribute("appUserId", appUser.getId());
//
//        m.addAttribute("testDate", LocalDateTime.now());
//
//        return "/user-info";
//    }



//    @PutMapping("/users/{id}")
//    public RedirectView editUserInfo(Model m, Principal p, @PathVariable Long id, String username, String nickname)
//    {
//        // given username and sessions username match
//        if ((p != null) && (p.getName().equals(username)))
//        {
//            CodeFellowshipUser newestUser = codeFellowshipRepo.findById(id).orElseThrow();
//            newestUser.setUsername(username);
//            codeFellowshipRepo.save(newestUser);
//        }
//
//        return new RedirectView("/users/" + id);
//    }


//}
