package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Page;
import com.Hratus.MangaFinder.demo.Repository.PageRepository;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
    //Analisar esse codigo depois e aprender oq cada coisa faz

    private PageRepository pageRepository;

     @Autowired
     public PageService(PageRepository pageRepository) {
         this.pageRepository = pageRepository;
     }

    private List<Page> pages = new ArrayList<>();  // Lista de páginas

    public List<Page> addPage(Page page, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if (response.isSuccessful() && response.body() != null) {
            byte[] imageBytes = response.body().bytes(); // Obtém os bytes da imagem

            // Define a URL da imagem no objeto Page
            page.setImageData(imageBytes);
            page.setImageUrl(url);

            pages.add(page); // Adiciona a página à lista
            System.out.println("Imagem adicionada com sucesso!");
        } else {
            System.out.println("Falha ao baixar a imagem.");
        }

        return pages; // Retorna a lista atualizada
    }


}
