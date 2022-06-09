package com.codefellowship.CodeFellowShip.controller;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import com.codefellowship.CodeFellowShip.model.Post;
import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MyProfileController {

    @Autowired
    CodeFellowshipRepo codeFellowshipRepo;

    @GetMapping("/myProfile")
    public String getHome(Principal p, Model m) {
        if (p != null) {
            String username = p.getName();
            CodeFellowshipUser user = codeFellowshipRepo.findByUsername(username);
            List<Post> postList = user.getUserPosts();

            m.addAttribute("user", user);
            m.addAttribute("posts", postList);
        }


        return "myProfile";
    }
}
