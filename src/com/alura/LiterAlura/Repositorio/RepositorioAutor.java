package com.alura.LiterAlura.Repositorio;

import com.alura.LiterAlura.Modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreAutor(String nombreAutor);

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libro")
    List<Autor> findAllWithLibros();

    @Query("SELECT a FROM Autor a WHERE LOWER(a.nombreAutor) LIKE LOWER(CONCAT('%', :nombreAutor, '%'))")
    List<Autor> buscarAutorPorNombre(@Param("nombreAutor") String nombreAutor);

    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.libro WHERE a.fechaDeNacimiento <= :anio AND (a.fechaDeFallecimiento >= :anio OR a.fechaDeFallecimiento IS NULL)")
    List<Autor> findByFechaDeNacimientoLessThanEqualAndFechaDeFallecimientoGreaterThanEqual(@Param("anio") int anio);
}

