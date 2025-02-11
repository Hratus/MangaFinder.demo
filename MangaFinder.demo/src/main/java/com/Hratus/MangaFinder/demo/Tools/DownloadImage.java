package com.Hratus.MangaFinder.demo.Tools;

import com.Hratus.MangaFinder.demo.Domain.Chapter;
import com.Hratus.MangaFinder.demo.Domain.Download;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class DownloadImage extends Download {

    public List<Chapter> downloadImage() throws IOException {
        OkHttpClient client = new OkHttpClient();
        OkHttpClient downloadImage;
        String url = "";
        try{
            Request request = new Request.Builder().url(url).get().build();
            Response response = client.newCall(request).execute();

            if(response.isSuccessful() && response.body() != null){
                Document document = Jsoup.parse(response.body().string());
                Elements elements= document.select("img");

                for(Element element : elements){
                    String imageUrl = element.attr("src");
                    if(!imageUrl.isEmpty()){
                        downloadImage();
                    }
                }
            } else {
                System.out.println("Error downloading image");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
