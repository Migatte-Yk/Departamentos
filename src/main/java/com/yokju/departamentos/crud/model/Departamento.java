
package com.yokju.departamentos.crud.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID_DEPARTAMENTO")
    private Long id;
    
    @Column (name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    
    @Column (name = "GOBERNADOR", length = 50, nullable = false)
    private String gobernador;
    
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Municipio> municipios;

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

    public String getGobernador() {
        return gobernador;
    }

    public void setGobernador(String governador) {
        this.gobernador = governador;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    
    
}
