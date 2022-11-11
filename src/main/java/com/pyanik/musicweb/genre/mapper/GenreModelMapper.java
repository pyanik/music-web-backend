package com.pyanik.musicweb.genre.mapper;

import com.pyanik.musicweb.common.model.Genre;
import com.pyanik.musicweb.genre.dto.GenreDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreModelMapper {
    GenreDto mapGenreEntityToGenreDto(Genre genre);
}
