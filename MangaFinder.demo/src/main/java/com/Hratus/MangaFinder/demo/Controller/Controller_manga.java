package com.Hratus.MangaFinder.demo.Controller;

import com.Hratus.MangaFinder.demo.Domain.Manga;
import com.Hratus.MangaFinder.demo.Service.Service_manga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Leia a linha de comentario da classe Controller_chapter
@RestController
@RequestMapping("/mangas")
public class Controller_manga {

    private Service_manga service_manga;
    //Injeção de dependencia
    @Autowired
    public Controller_manga(Service_manga service_manga) {
        this.service_manga = service_manga;
    }
    //Retorna uma lista Json com todos os mangas disponiveis
    @GetMapping
    public List<Manga> ListAllMangas(){
        //todos os comandos estão na service, literalmente uma abstração de uma abstrção
        return service_manga.List_all_mangas();
    }
    //Retorna um manga Pelo Id
    @GetMapping("/{id}")
    public Manga GetMangaById(@PathVariable Long id){
        return service_manga.Find_manga_by_id(id);

    }
    //Adiciona um manga
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manga AddManga(@RequestBody Manga manga){
        return service_manga.Save_manga(manga);
    }
    //Atualiza um manga pelo ID
    @PutMapping("/{id}")
    public Manga UpdateManga(@PathVariable Long id, @RequestBody Manga manga){
        return service_manga.Update_manga_by_id(id, manga);
    }
    //Deleta um manga pelo Id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteManga(@PathVariable Long id){
        service_manga.Delete_manga_by_id(id);
    }
    //Deleta todos os mangas
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteAllMangas(){
        service_manga.Delete_all_mangas();
    }

}
