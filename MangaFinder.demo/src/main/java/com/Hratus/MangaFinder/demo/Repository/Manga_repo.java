package com.Hratus.MangaFinder.demo.Repository;


import com.Hratus.MangaFinder.demo.Domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Manga_repo extends JpaRepository<Manga, Long> {


}
