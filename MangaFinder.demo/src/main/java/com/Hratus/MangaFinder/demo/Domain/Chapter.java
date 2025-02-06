package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//PARA EXPLICAÇÃO DAS @ LEIA AS CLASSES SCAN OU MANGA
@Entity(name = "chapter")
@Table(name="chapter")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chapter;
    private String title_chapter;
    private int image_chapter;

    @ManyToOne//Relacionamento N:1 com Manga
    private Manga manga;






}
