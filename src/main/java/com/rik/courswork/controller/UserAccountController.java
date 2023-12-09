package com.rik.courswork.controller;

import com.rik.courswork.entity.UserAccount;
import com.rik.courswork.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/anime")
@CrossOrigin(origins = "*")
public class UserAccountController {

    UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/user-account")
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount createdUserAccount = userAccountService.createUserAccount(userAccount);
        return ResponseEntity.ok(createdUserAccount);
    }

    @GetMapping("/user-account/login")
    public ResponseEntity<UserAccount> loginUser(@RequestParam String email, @RequestParam String password) {
        UserAccount loggedInUser = userAccountService.getUserByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
