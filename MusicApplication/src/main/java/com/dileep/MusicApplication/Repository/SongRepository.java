package com.dileep.MusicApplication.Repository;

import com.dileep.MusicApplication.Model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {
    // Custom query to support filtering songs by an album's artist
    @Query("SELECT s FROM Song s WHERE s.album.artist.id = :artistId")
    Page<Song> findByArtistId(@Param("artistId") Long artistId, Pageable pageable);
}
