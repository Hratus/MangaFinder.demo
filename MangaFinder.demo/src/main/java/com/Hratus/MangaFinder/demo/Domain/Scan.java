package com.Hratus.MangaFinder.demo.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;
//Entity é uma anotation pra mapear entidades do banco de dados
@Entity(name = "scan")
@Table(name= "scan")
@Getter @Setter
//Gera um construtor sem arguementos graças ao Lombok(necessario para entidades JPA)
@NoArgsConstructor
//gera um construtor com arguemntos graças ao lomboknecessario para entidades JPA)
@AllArgsConstructor
public class Scan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY gera um id com varios digitos e automaticamente sempre que for instanciado
    private Long id_scan;
    private String name_scan;
    private String url_scan;

    @ManyToOne//relacionamento N:1 com Manga. sendo muitos Scans para 1 manga
    private Manga manga;

    //Classes marcadas com @Entity podem ter construtores vazios, exeto que tambem estejam marcados com @NoArgsConstructor
    //Uso incorrerto de @Override pode gerar problemas com o hibernate


}
