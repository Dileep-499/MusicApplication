package com.dileep.MusicApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Song extends BaseModel {
    private String name;
    private Integer track;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    // Getters and Setters
}
