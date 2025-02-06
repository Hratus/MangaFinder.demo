package com.Hratus.MangaFinder.demo.Repository;

import com.Hratus.MangaFinder.demo.Domain.Scan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanRepoRepo extends JpaRepository<Scan, Long> {
}
