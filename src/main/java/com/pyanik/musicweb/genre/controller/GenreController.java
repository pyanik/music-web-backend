package com.pyanik.musicweb.genre.controller;

import com.pyanik.musicweb.genre.dto.GenreDto;
import com.pyanik.musicweb.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
class GenreController {

    private final GenreService genreService;

    @GetMapping("/genres")
    public List<GenreDto> getGenres() {
        return genreService.getGenres();
    }
}
