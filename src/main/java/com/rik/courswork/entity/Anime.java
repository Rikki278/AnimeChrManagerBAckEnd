package com.rik.courswork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

@Entity
public class Anime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String animeTitle; //change to anime

    private String description;

    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String specialCode;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserAccount user;

    @Column(name = "user_id")
    private Long userId;

    public Anime() {
    }

    public Anime(String name, String animeTitle, String description, String imageUrl, String specialCode, Long userId) {
        this.name = name;
        this.animeTitle = animeTitle;
        this.description = description;
        this.imageUrl = imageUrl;
        this.specialCode = specialCode;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animeTitle='" + animeTitle + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", specialCode='" + specialCode + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public void setAnimeTitle(String animeTitle) {
        this.animeTitle = animeTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

}
