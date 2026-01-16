package com.dileep.MusicApplication.Data;

import com.dileep.MusicApplication.Model.Album;
import com.dileep.MusicApplication.Model.Artist;
import com.dileep.MusicApplication.Model.Song;
import com.dileep.MusicApplication.Repository.AlbumRepository;
import com.dileep.MusicApplication.Repository.ArtistRepository;
import com.dileep.MusicApplication.Repository.SongRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired private ArtistRepository artistRepo;
    @Autowired private AlbumRepository albumRepo;
    @Autowired private SongRepository songRepo;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // PREVENT DUPLICATE SEEDING
        if (artistRepo.count() > 0) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, List<Map<String, Object>>>> typeRef = new TypeReference<>() {};

        InputStream is = getClass().getResourceAsStream("/db.json");
        Map<String, List<Map<String, Object>>> data = mapper.readValue(is, typeRef);

        // Maps to keep track of the new database IDs against the old JSON IDs
        Map<Long, Artist> artistMap = new HashMap<>();
        Map<Long, Album> albumMap = new HashMap<>();

        // 1. Seed Artists
        data.get("artists").forEach(item -> {
            Artist artist = new Artist();
            artist.setName((String) item.get("name"));
            // We save it and put the saved object (with the new DB ID) into our map
            Artist savedArtist = artistRepo.save(artist);
            artistMap.put(((Number) item.get("id")).longValue(), savedArtist);
        });

        // 2. Seed Albums
        data.get("albums").forEach(item -> {
            Album album = new Album();
            album.setName((String) item.get("name"));
            album.setYearReleased((Integer) item.get("year_released"));

            // Get the correct artist from our map using the old JSON ID
            Long oldArtistId = Long.parseLong(item.get("artist_id").toString());
            album.setArtist(artistMap.get(oldArtistId));

            Album savedAlbum = albumRepo.save(album);
            albumMap.put(((Number) item.get("id")).longValue(), savedAlbum);
        });

        // 3. Seed Songs
        data.get("songs").forEach(item -> {
            Song song = new Song();
            song.setName((String) item.get("name"));
            song.setTrack((Integer) item.get("track"));

            // Get the correct album from our map using the old JSON ID
            Long oldAlbumId = ((Number) item.get("album_id")).longValue();
            song.setAlbum(albumMap.get(oldAlbumId));

            songRepo.save(song);
        });

        System.out.println("✅ Database seeded successfully!");
    }
}