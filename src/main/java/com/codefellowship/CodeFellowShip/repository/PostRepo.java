package com.codefellowship.CodeFellowShip.repository;

import com.codefellowship.CodeFellowShip.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
