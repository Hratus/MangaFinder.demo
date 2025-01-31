package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Manga;
import com.Hratus.MangaFinder.demo.Exeptions.MangaNotFoundExeption;
import com.Hratus.MangaFinder.demo.Repository.Manga_repo;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

//Essa camada representa a logica de negocio, servindo para evitar que ela seja feita na controller e ao mesmo tempo mediando a DTo
@Service
public class Service_manga {



    private Manga_repo repository_manga;

    //injeção de dependencia
    @Autowired
    public Service_manga(Manga_repo repository_manga) {
        this.repository_manga = repository_manga;
    }

    //Lista todos os mangas disponiveis
    public List<Manga> List_all_mangas() {
        //.findAll é um metodo pronto da repository, mas posso criar novos para atender as demandas da regras de negocio
        return repository_manga.findAll();
    }

    //Acha um manga pelo ID dele, e caso não exista devolve aquela mensagem;
    public Manga Find_manga_by_id (Long id){

        return repository_manga.findById(id).orElseThrow(() -> new MangaNotFoundExeption("Manga not found" + id));

    }

    //Salva o manga no banco
    public Manga Save_manga (Manga manga){
        return repository_manga.save(manga);
    }

    //Atualiza um manga pelo Id e depois salva utilizando Save_manga
    public Manga Update_manga_by_id (Long id, Manga manga_update ){
        //Variavel de "Transição", para receber e passar para a outra (manga_update)
        Manga manga_up_to_date = Find_manga_by_id(id);
        //EM caso de erro substituir por esse
        //repository_manga.findById(id).orElseThrow(() -> new RuntimeException("Manga not found"));




            //Atializa o setta um novo titulo e o manga_update recebe o novo//
            manga_up_to_date.setTitle_manga( manga_update.getTitle_manga() );
            manga_up_to_date.setAuthor_manga( manga_update.getAuthor_manga() );
            manga_up_to_date.setDescription_manga( manga_update.getDescription_manga() );
            manga_up_to_date.setUrl_manga( manga_update.getUrl_manga() );
            manga_up_to_date.setGenre_manga( manga_update.getGenre_manga() );
            manga_up_to_date.setNumber_of_chapters( manga_update.getNumber_of_chapters() );

            return Save_manga(manga_up_to_date);
        //Poderia usar o repository_manga.save ao invez do Save_manga
        //return Save_manga(manga_up_to_date);
    }
    //transação atomica, tudo ou nada
    @Transactional
    //Deleta um manga com base no id
    public Manga Delete_manga_by_id (Long id){
        Manga manga_to_delete = repository_manga.findById(id).orElseThrow(() -> new MangaNotFoundExeption("Manga not found"));

        repository_manga.delete(manga_to_delete);
        return manga_to_delete;

    }

    //Deleta todos os mangas disponiveis
    public void Delete_all_mangas(){

        repository_manga.deleteAll();

    }



}
