package com.dileep.MusicApplication.Controllers;

import com.dileep.MusicApplication.Model.Song;
import com.dileep.MusicApplication.Services.SongService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongController {


    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public Page<Song> getSongs(
            @RequestParam(name = "album.artist_id", required = false) Long artistId,
            @PageableDefault(size = 10) Pageable pageable) {

        if (artistId != null) {
            return songService.findByArtistId(artistId, pageable);
        }
        return songService.findAll(pageable);
    }
}

