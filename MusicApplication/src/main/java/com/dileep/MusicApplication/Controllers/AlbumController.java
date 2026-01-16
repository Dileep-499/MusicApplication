package com.dileep.MusicApplication.Controllers;

import com.dileep.MusicApplication.Model.Album;
import com.dileep.MusicApplication.Services.AlbumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {


    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public Page<Album> getAlbums(
            @RequestParam(required = false) Long artist_id,
            @PageableDefault(size = 10) Pageable pageable) {

        if (artist_id != null) {
            return albumService.findByArtistId(artist_id, pageable);
        }
        return albumService.findAll(pageable);
    }
}

