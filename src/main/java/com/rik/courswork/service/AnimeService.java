package com.rik.courswork.service;

import com.rik.courswork.entity.UserAccount;
import com.rik.courswork.exception.UserNotFoundException;
import com.rik.courswork.entity.Anime;
import com.rik.courswork.repo.AnimeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AnimeService {

    private final AnimeRepo animeRepo;

    @Autowired
    public AnimeService(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public Anime addAnime(Anime anime) {
        anime.setSpecialCode(UUID.randomUUID().toString());
        return animeRepo.save(anime);
    }

    public List<Anime> findAllAnime() {
        return animeRepo.findAll();
    }

    //find by user
    public List<Anime> findAnimeByUserId(Long id) {
        return animeRepo.findByUserId(id);
    }

    public Anime updateAnime(Anime anime) {
        return animeRepo.save(anime);
    }

    public Anime findAnimeById(Long id) {
        return animeRepo.findAnimeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteAnime(Long id) {
        animeRepo.deleteAnimeById(id);
        ;
    }


    public Anime updateAnimeById(Long id, Anime updatedAnime) {
        System.out.println(updatedAnime);

        Anime existingAnime = animeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Anime not found with id: " + id));

        System.out.println(existingAnime);

        // Update the existingAnime entity with values from updatedAnime
        //BeanUtils.copyProperties(updatedAnime, existingAnime, "id", "specialCode");

        existingAnime.setName(updatedAnime.getName());
        existingAnime.setDescription(updatedAnime.getDescription());
        existingAnime.setAnimeTitle(updatedAnime.getAnimeTitle());
        existingAnime.setImageUrl(updatedAnime.getImageUrl());


        return animeRepo.save(existingAnime);
    }
}
