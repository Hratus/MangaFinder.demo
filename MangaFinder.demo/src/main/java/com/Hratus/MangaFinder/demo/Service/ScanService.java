package com.Hratus.MangaFinder.demo.Service;

import com.Hratus.MangaFinder.demo.Domain.Scan;
import com.Hratus.MangaFinder.demo.Exeptions.ScanNotFoundExeption;
import com.Hratus.MangaFinder.demo.Repository.ScanRepoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanService {

    private final ScanRepoRepo scanRepository;
    //Injeção de dependencia
    @Autowired
    public ScanService(ScanRepoRepo scanRepository) {
        this.scanRepository = scanRepository;
    }
    //Lista todos os Scans
    public List<Scan> ListAllScans() {
        return scanRepository.findAll();
    }
    //Retorna um scan pelo ID
    public Scan FindOne(Long id){
        return scanRepository.findById(id).orElseThrow(() -> new ScanNotFoundExeption("Scan Not Found"));
    }
    //Salva um scan
    public Scan SaveScan(Scan scan){

        return scanRepository.save(scan);
    }
    //Atualiza os dados de um scan
    public Scan UpdateOne(Long id, Scan scanUpdate){
        Scan scan = FindOne(id);

        scan.setName_scan(scanUpdate.getName_scan());
        scan.setUrl_scan(scanUpdate.getUrl_scan());
        return SaveScan(scan);
    }
    //Deleta um scan
    @Transactional
    public Scan DeleteOne(Long id){
        Scan scan = FindOne(id);
       scanRepository.delete(scan);
       return scan;
    }
    //Deleta todos os scans
    @Transactional
    public void DeleteAll(){
        scanRepository.deleteAll();
    }
}
