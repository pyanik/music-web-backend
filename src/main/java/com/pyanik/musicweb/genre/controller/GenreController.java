package com.pyanik.musicweb.genre.controller;

import com.pyanik.musicweb.album.dto.AlbumDto;
import com.pyanik.musicweb.album.service.AlbumService;
import com.pyanik.musicweb.genre.dto.GenreDto;
import com.pyanik.musicweb.genre.service.GenreService;
import com.pyanik.musicweb.homepage.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    private final AlbumService albumService;

    @GetMapping("/genres")
    public ResponseEntity<List<GenreDto>> getGenres() {
        return ResponseEntity.ok(genreService.getGenres());
    }

    @GetMapping("/genres/{name}")
    public ResponseEntity<Page<AlbumDto>> getGenreAlbums(@PathVariable(value = "name") String genreName,
                                                         @PageableDefault(size = 5) Pageable pageable) {
        genreService.findGenreByName(genreName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Page<AlbumDto> albumDtos = albumService.getAlbumsByGenreName(pageable, genreName);
        return ResponseEntity.ok(albumDtos);
    }
}
