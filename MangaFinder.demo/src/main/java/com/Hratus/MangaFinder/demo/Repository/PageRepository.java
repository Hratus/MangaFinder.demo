package com.Hratus.MangaFinder.demo.Repository;

import com.Hratus.MangaFinder.demo.Domain.Page;
import com.Hratus.MangaFinder.demo.Domain.PageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, PageId> {
}
