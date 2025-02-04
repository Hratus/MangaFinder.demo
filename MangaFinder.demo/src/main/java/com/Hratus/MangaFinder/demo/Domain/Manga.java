package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="manga")//Indica que essa classe é uma entidade de Banco de Dados
@Table(name="manga")//Define o nome da tabela
@Getter
@Setter//Gera automaticamente os Getters e Setters
@NoArgsConstructor//Gera um Construtor sem argumentos
@AllArgsConstructor//Gera um Construtor com argumentos
public class Manga {
    @Id//chave primaria de Manga
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera automaticamente os IDs
    private Long id_manga;
    private String title_manga;
    private String author_manga;
    private String description_manga;
    private String url_manga;
    private String genre_manga;
    private int number_of_chapters;

    //@OneToOne// ainda pegando o jeito, mas seria cada cap pertence a 1 e somente 1 manga
   // private Chapter chapter;
    //@ManyToOne// ainda pegando, seriam varios mangas pertencem a 1 e somente 1 scan
   // private Scan scan;

    //Getters e settersl, por alguma razão o lombok não esta funcionando para isso
    public Long getId_manga() {
        return id_manga;
    }

    public void setId_manga(Long id_manga) {
        this.id_manga = id_manga;
    }

    public String getTitle_manga() {
        return title_manga;
    }

    public void setTitle_manga(String title_manga) {
        this.title_manga = title_manga;
    }

    public String getAuthor_manga() {
        return author_manga;
    }

    public void setAuthor_manga(String author_manga) {
        this.author_manga = author_manga;
    }

    public String getDescription_manga() {
        return description_manga;
    }

    public void setDescription_manga(String description_manga) {
        this.description_manga = description_manga;
    }

    public String getUrl_manga() {
        return url_manga;
    }

    public void setUrl_manga(String url_manga) {
        this.url_manga = url_manga;
    }

    public String getGenre_manga() {
        return genre_manga;
    }

    public void setGenre_manga(String genre_manga) {
        this.genre_manga = genre_manga;
    }

    public int getNumber_of_chapters() {
        return number_of_chapters;
    }

    public void setNumber_of_chapters(int number_of_chapters) {
        this.number_of_chapters = number_of_chapters;
    }

}
