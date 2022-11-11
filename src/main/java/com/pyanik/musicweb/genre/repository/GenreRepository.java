package com.pyanik.musicweb.genre.repository;

import com.pyanik.musicweb.common.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
