package com.dileep.MusicApplication.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Artist extends BaseModel {
    private String name;
    // Getters and Setters
}
