package com.dileep.MusicApplication.Controllers;

import com.dileep.MusicApplication.Model.Artist;
import com.dileep.MusicApplication.Services.ArtistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")

public class ArtistController {


    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public Page<Artist> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return artistService.findAll(pageable);
    }
}

