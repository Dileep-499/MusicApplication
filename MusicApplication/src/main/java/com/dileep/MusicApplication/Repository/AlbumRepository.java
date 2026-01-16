package com.dileep.MusicApplication.Repository;

import com.dileep.MusicApplication.Model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Page<Album> findByArtistId(Long artistId, Pageable pageable);
}
