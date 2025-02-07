package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


//PARA EXPLICAÇÃO DAS @ LEIA AS CLASSES SCAN OU MANGA
@Entity(name = "chapter")
@Table(name= "chapter")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chapterId;
    private String chapterTitle;
    private Double chapterNumber;

    // cascade = CascadeType.ALL Permite que, ao excluir um capítulo, todas as páginas associadas também sejam excluídas.7
    //@OneToMany(mappedBy = "chapter")Define a relação 1:N com Page, onde um capítulo tem várias páginas.
    //orphanRemoval = true Remove automaticamente páginas que não estão mais associadas a nenhum capítulo.
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pages;


    @ManyToOne
    @JoinColumn(name = "id_manga", nullable = false)
    private Manga manga;





}
