package com.dileep.MusicApplication.Services;

import com.dileep.MusicApplication.Model.Song;
import com.dileep.MusicApplication.Repository.SongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService {


    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    public Page<Song> findByArtistId(Long artistId, Pageable pageable) {
        return songRepository.findByArtistId(artistId, pageable);
    }
}

