package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageId implements Serializable {
    private Long chapterId;


    private int pageNumber;
}
