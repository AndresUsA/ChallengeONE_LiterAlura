package com.alura.LiterAlura.Modelos;

import jakarta.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Autor> autores;

    private Double numeroDeDescargas;

    @ElementCollection(targetClass = Idioma.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "lenguajes", joinColumns = @JoinColumn(name = "libro_id"))
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "lenguaje")
    private Set<Idioma> lenguajes;

    // Constructor por defecto
    public Libro() {}

    public Libro(String titulo, Set<Autor> autores, Double numeroDeDescargas, Set<Idioma> lenguajes) {
        this.titulo = titulo;
        this.autores = autores;
        this.numeroDeDescargas = numeroDeDescargas;
        this.lenguajes = lenguajes;
    }

    @Override
    public String toString() {
        return "*********** Libro ***********\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autores.stream().map(Autor::getNombreAutor).collect(Collectors.joining(", ")) + "\n" +
                "Lenguaje: " + lenguajes + "\n" +
                "Número de descargas: " + numeroDeDescargas + "\n";
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Set<Idioma> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(Set<Idioma> lenguajes) {
        this.lenguajes = lenguajes;
    }
}
