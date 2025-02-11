package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Chapter;
import com.Hratus.MangaFinder.demo.Domain.Manga;
import com.Hratus.MangaFinder.demo.Domain.Page;
import com.Hratus.MangaFinder.demo.Exeptions.ChapterNotFoundExeption;
import com.Hratus.MangaFinder.demo.Repository.ChapterRepository;
import com.Hratus.MangaFinder.demo.Repository.MangaRepository;
import com.Hratus.MangaFinder.demo.Tools.DownloadImage;
import jakarta.transaction.Transactional;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService extends DownloadImage {

    private final ChapterRepository chapterRepository;
    private DownloadImage downloadImage;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository, DownloadImage downloadImage) {
        this.chapterRepository = chapterRepository;
        this.downloadImage = downloadImage;
    }



    /// Lista de páginas

    public List<Chapter> addChapters(List<Chapter> chapters) throws IOException {
        if (chapters == null || chapters.isEmpty()) {
            throw new IllegalArgumentException("A lista de capítulos está vazia.");
        }

        return chapterRepository.saveAll(chapters);
    }
}














