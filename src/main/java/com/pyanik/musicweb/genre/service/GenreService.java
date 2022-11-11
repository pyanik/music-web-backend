package com.pyanik.musicweb.genre.service;

import com.pyanik.musicweb.common.model.Genre;
import com.pyanik.musicweb.genre.dto.GenreDto;
import com.pyanik.musicweb.genre.mapper.GenreModelMapper;
import com.pyanik.musicweb.genre.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public
class GenreService {

    private final GenreRepository genreRepository;

    private final GenreModelMapper genreModelMapper;

    public List<GenreDto> getGenres() {
        return genreRepository.findAll().stream()
                .map(genreModelMapper::mapGenreEntityToGenreDto)
                .toList();
    }
}
