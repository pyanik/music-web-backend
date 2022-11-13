package com.pyanik.musicweb.homepage.service;

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
public class HomePageService {

    private final AlbumRepository albumRepository;

    private final AlbumModelMapper albumModelMapper;

    public Page<AlbumDto> getAllPromotedAlbums(Pageable pageable) {
        Page<Album> allPromotedAlbumsPage = albumRepository.findAllByPromotedIsTrue(pageable);
        List<AlbumDto> allPromotedAlbumsDtos = allPromotedAlbumsPage.stream().
                map(albumModelMapper::mapAlbumEntityToAlbumDto).
                toList();
        return new PageImpl<>(allPromotedAlbumsDtos, pageable, allPromotedAlbumsPage.getTotalElements());
    }
}
