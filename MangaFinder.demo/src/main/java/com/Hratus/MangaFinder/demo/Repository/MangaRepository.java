package com.Hratus.MangaFinder.demo.Repository;


import com.Hratus.MangaFinder.demo.Domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {


}
