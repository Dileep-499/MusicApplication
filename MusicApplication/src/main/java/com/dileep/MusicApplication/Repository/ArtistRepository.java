package com.dileep.MusicApplication.Repository;

import com.dileep.MusicApplication.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {}


