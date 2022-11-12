package com.pyanik.musicweb.album.service;

import com.pyanik.musicweb.album.mapper.AlbumModelMapper;
import com.pyanik.musicweb.album.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public
class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumModelMapper albumModelMapper;

}
