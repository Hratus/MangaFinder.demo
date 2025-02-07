package com.Hratus.MangaFinder.demo.Repository;

import com.Hratus.MangaFinder.demo.Domain.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
