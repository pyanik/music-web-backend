package com.pyanik.musicweb.album.controller;

import com.pyanik.musicweb.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AlbumController {

    private final AlbumService albumService;
}
