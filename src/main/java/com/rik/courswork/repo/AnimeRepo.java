package com.rik.courswork.repo;

import com.rik.courswork.entity.Anime;
import com.rik.courswork.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeRepo extends JpaRepository<Anime, Long> {
    void deleteAnimeById(Long id);

    Optional<Anime> findAnimeById(Long id);

//    @Query("SELECT a FROM Anime a WHERE a.user = :id")
//    List<Anime> findAnimeByUserId(@Param("id") Long id);

    //List<Anime> findByUser(UserAccount userAccount);
    List<Anime> findByUserId(Long id);

    //Optional<Anime> findAnimeByEmail(String email);
}
