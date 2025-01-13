
package com.yokju.departamentos.crud.repository;

import com.yokju.departamentos.crud.model.Departamento;
import com.yokju.departamentos.crud.model.Municipio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipioRepository extends JpaRepository <Municipio, Long>{
    List<Municipio> findByDepartamento(Departamento departamento);
}
