package com.dileep.MusicApplication.Services;

import com.dileep.MusicApplication.Model.Album;
import com.dileep.MusicApplication.Repository.AlbumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {


    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Page<Album> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    public Page<Album> findByArtistId(Long artistId, Pageable pageable) {
        return albumRepository.findByArtistId(artistId, pageable);
    }
}
