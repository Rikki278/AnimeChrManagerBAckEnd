package com.rik.courswork.repo;

import com.rik.courswork.entity.Anime;
import com.rik.courswork.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepo extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findUserAccountById(Long id);
    UserAccount findByEmailAndPassword(String email, String password);
    UserAccount findByEmail(String email);


//    Optional<UserAccount> findByEmail
}
