package com.pyanik.musicweb.album.service;

import com.pyanik.musicweb.album.dto.AlbumDto;
import com.pyanik.musicweb.album.mapper.AlbumModelMapper;
import com.pyanik.musicweb.album.repository.AlbumRepository;
import com.pyanik.musicweb.common.model.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final AlbumModelMapper albumModelMapper;

    public AlbumDto getAlbumById(Long id) {
        Album album = albumRepository.findById(id).orElseThrow();
        return albumModelMapper.mapAlbumEntityToAlbumDto(album);
    }

    public Page<AlbumDto> getAlbumsByGenreName(Pageable pageable, String genreName) {
        Page<Album> albums = albumRepository.findAllByGenre_NameIgnoreCase(genreName, pageable);
        List<AlbumDto> albumDtos = albums.stream().map(albumModelMapper::mapAlbumEntityToAlbumDto).toList();
        return new PageImpl<>(albumDtos, pageable, albums.getTotalElements());
    }
}
