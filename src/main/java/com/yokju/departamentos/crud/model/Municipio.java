
package com.yokju.departamentos.crud.model;

import jakarta.persistence.*;

@Entity
@Table (name = "MUNICIPIO")
public class Municipio {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_MUNICIPIO")
    private Long id;
    
    @Column (name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn (name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    private Departamento departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
