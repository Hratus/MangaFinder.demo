package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

///Entity é uma anotation pra mapear entidades do banco de dados
@Entity(name = "scan")
@Table(name= "scan")
@Getter @Setter
///Gera um construtor sem arguementos graças ao Lombok(necessario para entidades JPA)
@NoArgsConstructor
///gera um construtor com arguemntos graças ao lomboknecessario para entidades JPA)
@AllArgsConstructor
public class Scan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY gera um id com varios digitos e automaticamente sempre que for instanciado
    private Long id_scan;
    private String name_scan;
    private String url_scan;

    ///@ManyToOne//relacionamento N:1 com Manga. sendo muitos Scans para 1 manga
    ///private Manga manga;

    ///Classes marcadas com @Entity podem ter construtores vazios, exeto que tambem estejam marcados com @NoArgsConstructor
    ///Uso incorrerto de @Override pode gerar problemas com o hibernate



    public Long getId_scan() {
        return id_scan;
    }

    public void setId_scan(Long id_scan) {
        this.id_scan = id_scan;
    }

    public String getName_scan() {
        return name_scan;
    }

    public void setName_scan(String name_scan) {
        this.name_scan = name_scan;
    }

    public String getUrl_scan() {
        return url_scan;
    }

    public void setUrl_scan(String url_scan) {
        this.url_scan = url_scan;
    }
}
