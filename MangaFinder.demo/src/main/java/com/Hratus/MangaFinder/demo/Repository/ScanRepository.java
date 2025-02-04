package com.Hratus.MangaFinder.demo.Repository;

import com.Hratus.MangaFinder.demo.Domain.Scan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<Scan, Long> {
}
