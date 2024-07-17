package com.alura.LiterAlura.Repositorio;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l JOIN FETCH l.lenguajes lenguajes JOIN FETCH l.autores WHERE lenguajes = :idioma")
    List<Libro> findByIdioma(@Param("idioma") Idioma idioma);

    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autores LEFT JOIN FETCH l.lenguajes WHERE l.id = :id")
    Optional<Libro> findByIdWithAutoresAndLenguajes(@Param("id") Long id);

    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autores LEFT JOIN FETCH l.lenguajes")
    List<Libro> findAllWithAutoresAndLenguajes();
}

