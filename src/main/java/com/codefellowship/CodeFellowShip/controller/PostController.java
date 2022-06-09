package com.codefellowship.CodeFellowShip.controller;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import com.codefellowship.CodeFellowShip.model.Post;
import com.codefellowship.CodeFellowShip.repository.CodeFellowshipRepo;
import com.codefellowship.CodeFellowShip.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;


    @Controller
    public class PostController {

        @Autowired
        CodeFellowshipRepo codeFellowshipRepo;

        @Autowired
        PostRepo postRepo;

        @PostMapping("/addPost")
        public RedirectView addPost(String body, String username){
            CodeFellowshipUser user = codeFellowshipRepo.findByUsername(username);
            Post newPost = new Post(body, new Date(),user);
            postRepo.save(newPost);

            return new RedirectView("/myProfile");
        }
}
