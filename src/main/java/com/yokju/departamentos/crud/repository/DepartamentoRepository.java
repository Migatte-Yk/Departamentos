
package com.yokju.departamentos.crud.repository;

import com.yokju.departamentos.crud.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository <Departamento, Long> {
    
}
