package com.Hratus.MangaFinder.demo.Controller;

import com.Hratus.MangaFinder.demo.Domain.Manga;
import com.Hratus.MangaFinder.demo.Service.MangaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Leia a linha de comentario da classe ChapterController
@RestController
@RequestMapping("/mangas")
public class MangaController {

    private final MangaService mangaService;

    //Injeção de dependencia
    @Autowired
    public MangaController(MangaService mangaService) {
        this.mangaService = mangaService;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Listar todos os Mangas", description = "Retorna a lista de todos os mangas disponiveis")
    public List<Manga> ListAllMangas(){
        //todos os comandos estão na service, literalmente uma abstração de uma abstrção
        return mangaService.ListAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Retorna um usuaio pelo ID", description = "Com base no id retorna as descrições de um manga")
    public Manga GetMangaById(@PathVariable Long id){
        return mangaService.FindOne(id);

    }


    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    @Tag(name = "Adicionar Manga", description = "adiciona as informações de um manga")
    public Manga AddManga( @RequestBody Manga manga){
        return mangaService.SaveManga(manga);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Atualizar dados de um manga", description = "atualiza os dados a escolha, pelo ID")
    public Manga UpdateManga(@PathVariable Long id, @RequestBody Manga manga){
        return mangaService.UpdateById(id, manga);
    }


    @DeleteMapping("/{id}")
    @Tag(name = "Deletar um manga", description = "Deleta um manga pelo Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteManga(@PathVariable Long id){
        mangaService.DeleteById(id);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name = "Deletar todos os mangas", description = "Deleta todos os mangas do banco")
    public void DeleteAllMangas(){
        mangaService.DeleteAllData();
    }

}
