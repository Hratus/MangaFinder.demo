package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
///Page e pageId se complementam, onde garantem que cada pagina seja unica
@Entity(name="pages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    @EmbeddedId
    private PageId id;
    private String pageUrl;
    private String imageUrl;
    private byte[] imageData;

    @ManyToOne //Varias paginas para 1 capitulo
    @MapsId("chapterId")
    @JoinColumn(name = "chapterId")
    private Chapter chapter;

}
