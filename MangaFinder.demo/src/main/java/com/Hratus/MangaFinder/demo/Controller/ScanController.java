package com.Hratus.MangaFinder.demo.Controller;

import com.Hratus.MangaFinder.demo.Domain.Scan;
import com.Hratus.MangaFinder.demo.Service.ScanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Leia a linha de comentario da classe ChapterController
@RestController
@RequestMapping("/scan")
public class ScanController {

    private final ScanService scanService;
    @Autowired
    public ScanController(ScanService scanService) {
        this.scanService = scanService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Listar Scans", description = "Retorna a lista de todos os Scans disponiveis")
    public List<Scan> ListAllScans(){
        //todos os comandos estão na service, literalmente uma abstração de uma abstrção
        return scanService.ListAllScans();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Retornar Scan pelo Id", description = "Retorna apenas um Scan com base no id")
    public Scan FindById(@PathVariable Long id){
        return scanService.FindOne(id);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name ="Criar novo Scan", description = "Adiciona um novo scan no banco de dados da api")
    public Scan AddScan(@RequestBody Scan scan){
        return scanService.SaveScan(scan);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Tag(name = "Atualizar um Scan", description = "Atualiza um Scan existente pelo ID")
    public Scan UpdateScan(@PathVariable Long id, @RequestBody Scan scan){
        return scanService.UpdateOne(id, scan);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name="Deletar um Scan", description = "Deleta Scan com base no ID")
    public void DeleteScan(@PathVariable Long id){
        scanService.DeleteOne(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Tag(name= "Deletar todos ", description = "Deleta todos os scans armazenados")
    public void DeleteAllScans(){
        scanService.DeleteAll();
    }


}
