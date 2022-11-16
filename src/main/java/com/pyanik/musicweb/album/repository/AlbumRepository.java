package com.pyanik.musicweb.album.repository;

import com.pyanik.musicweb.common.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Page<Album> findAllByPromotedIsTrue(Pageable pageable);

    Page<Album> findAllByGenre_NameIgnoreCase(String genreName, Pageable pageable);
}
