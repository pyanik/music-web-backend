package com.pyanik.musicweb.homepage.controller;

import com.pyanik.musicweb.album.dto.AlbumDto;
import com.pyanik.musicweb.homepage.service.HomePageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class HomePageController {

    private final HomePageService homePageService;

    @GetMapping("")
    public ResponseEntity<Page<AlbumDto>> getAllPromotedAlbums(@PageableDefault(size = 5) Pageable pageable) {
        Page<AlbumDto> albumDtos = homePageService.getAllPromotedAlbums(pageable);
        return ResponseEntity.ok(albumDtos);
    }
}
