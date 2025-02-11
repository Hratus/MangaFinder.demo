package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Page;
import com.Hratus.MangaFinder.demo.Repository.PageRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {


    private final PageRepository pageRepository;

     @Autowired
     public PageService(PageRepository pageRepository) {
         this.pageRepository = pageRepository;
     }



    }



