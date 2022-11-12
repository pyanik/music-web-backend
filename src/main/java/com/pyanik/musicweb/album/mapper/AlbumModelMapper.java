package com.pyanik.musicweb.album.mapper;

import com.pyanik.musicweb.album.dto.AlbumDto;
import com.pyanik.musicweb.common.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlbumModelMapper {

    @Mapping(target = "genre", source = "album.genre.name")
    AlbumDto mapAlbumEntityToAlbumDto(Album album);
}
