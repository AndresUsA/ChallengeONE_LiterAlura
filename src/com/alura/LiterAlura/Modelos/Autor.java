package com.alura.LiterAlura.Modelos;

import jakarta.persistence.*;
    @Entity
    @Table(name = "Autores")
    public class Autor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true)
        private String nombreAutor;
        private Integer fechaNacimiento;
        private Integer fechaFallecimiento;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "Libro_id")
        private Libro libro;

        public Autor() {}

        public Autor(DatosAutor datosAutor) {
            this.nombreAutor = datosAutor.nombre();
            this.fechaNacimiento = datosAutor.fechaNacimiento();
            this.fechaFallecimiento = datosAutor.fechaFallecimiento();
        }

        public Autor(String nombreAutor, Integer fechaNacimiento, Integer fechaFallecimiento) {
            this.nombreAutor = nombreAutor;
            this.fechaNacimiento = fechaNacimiento;
            this.fechaFallecimiento = fechaFallecimiento;
        }

        @Override
        public String toString() {
            return "*********** Autor **********\n" +
                    "Nombre: " + nombreAutor + "\n" +
                    "Año de nacimiento: " + fechaNacimiento + "\n" +
                    "Año de fallecimiento: " + fechaFallecimiento + "\n" +
                    "Libro: " + libro + "\n";
        }

        //Getters y Setters


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombreAutor() {
            return nombreAutor;
        }

        public void setNombreAutor(String nombreAutor) {
            this.nombreAutor = nombreAutor;
        }

        public Integer getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Integer fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public Integer getFechaFallecimiento() {
            return fechaFallecimiento;
        }

        public void setFechaFallecimiento(Integer fechaFallecimiento) {
            this.fechaFallecimiento = fechaFallecimiento;
        }

        public Libro getLibro() {
            return libro;
        }

        public void setLibro(Libro libro) {
            this.libro = libro;
        }
    }
