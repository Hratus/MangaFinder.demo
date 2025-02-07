package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Chapter;
import com.Hratus.MangaFinder.demo.Domain.Manga;
import com.Hratus.MangaFinder.demo.Exeptions.ChapterNotFoundExeption;
import com.Hratus.MangaFinder.demo.Repository.ChapterRepository;
import com.Hratus.MangaFinder.demo.Repository.MangaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;


   @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }





}
