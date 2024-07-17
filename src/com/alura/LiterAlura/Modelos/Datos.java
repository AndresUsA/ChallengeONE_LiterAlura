package com.alura.LiterAlura.Modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("count") Double total,
        @JsonAlias("results") List<DatosLibro> resultados
        ) {
}
