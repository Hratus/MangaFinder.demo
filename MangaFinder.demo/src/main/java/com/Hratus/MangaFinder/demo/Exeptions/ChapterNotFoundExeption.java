package com.Hratus.MangaFinder.demo.Exeptions;

public class ChapterNotFoundExeption extends RuntimeException {
    public ChapterNotFoundExeption(String message) {
        super(message);
    }
}
