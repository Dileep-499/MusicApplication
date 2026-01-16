package com.dileep.MusicApplication.Services;

import com.dileep.MusicApplication.Model.Artist;
import com.dileep.MusicApplication.Repository.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {


    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Page<Artist> findAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }
}

