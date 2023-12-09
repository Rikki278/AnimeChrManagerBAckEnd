package com.rik.courswork.service;

import com.rik.courswork.entity.UserAccount;
import com.rik.courswork.repo.UserAccountRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAccountService {

    private final UserAccountRepo userAccountRepo;


    public boolean isUserExists(UserAccount userAccount) {
        // Например, проверка по уникальному идентификатору пользователя или другим критериям
        // Реализуйте логику проверки существования пользователя здесь
        // Возвращайте true, если пользователь уже существует, иначе false

        // Пример проверки по уникальному идентификатору (предполагается, что у UserAccount есть getId())
        return userAccountRepo.existsById(userAccount.getId());
    }

    @Autowired
    public UserAccountService(UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    //added return
    public UserAccount createUserAccount(UserAccount userAccount) {
        return userAccountRepo.save(userAccount);
    }

    //check if exist user account
    public UserAccount doLogin(String email, String password) {
        System.out.println("UserAccountService " + email + " " + password);
        System.out.println(userAccountRepo.findByEmailAndPassword(email, password));
        UserAccount userAccount = userAccountRepo.findByEmailAndPassword(email, password);
        return userAccount;
    }

    public UserAccount getUserByEmailAndPassword(String email, String password) {
        return userAccountRepo.findByEmailAndPassword(email, password);
    }

}
