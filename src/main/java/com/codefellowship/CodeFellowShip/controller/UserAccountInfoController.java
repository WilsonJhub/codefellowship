package com.codefellowship.CodeFellowShip.controller;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import com.codefellowship.CodeFellowShip.model.Post;
import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;
import java.util.List;

@Controller
public class UserAccountInfoController {

    @Autowired
    CodeFellowshipRepo codeFellowshipRepo;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @GetMapping("/user/{id}")
    public String getUserInfo(Principal p, Model m, @PathVariable Long id) {
        if (p != null) {
            String username = p.getName();
            CodeFellowshipUser appUser = codeFellowshipRepo.findByUsername(username);

            m.addAttribute("sessionUsername", username);
        } else {
            throw new ResourceNotFoundException("This is a 404");
        }

        CodeFellowshipUser appUser = codeFellowshipRepo.findById(id).orElseThrow();
        m.addAttribute("dbUsername", appUser.getUsername());
        m.addAttribute("dbUserId", appUser.getId());
        List<Post> postList = appUser.getUserPosts();
        m.addAttribute("posts", postList);


        return "user-info";
    }
}