package com.dileep.MusicApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Album extends BaseModel {
    private String name;
    private Integer yearReleased;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    // Getters and Setters
}
