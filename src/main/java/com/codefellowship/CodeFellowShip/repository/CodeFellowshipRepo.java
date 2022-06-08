package com.codefellowship.CodeFellowShip.repository;

import com.codefellowship.CodeFellowShip.model.CodeFellowshipUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeFellowshipRepo extends JpaRepository<CodeFellowshipUser, Long> {
    CodeFellowshipUser findByUsername(String username);
}
