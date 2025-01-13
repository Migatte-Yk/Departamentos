
package com.yokju.departamentos.crud.controller;

import com.yokju.departamentos.crud.model.Departamento;
import com.yokju.departamentos.crud.model.Municipio;
import com.yokju.departamentos.crud.repository.DepartamentoRepository;
import com.yokju.departamentos.crud.repository.MunicipioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @Autowired
    private MunicipioRepository municipioRepository;
    
    // Index
    
    @GetMapping("/")
    public String index (Model model){
        return "index";
    }
    
    // Mostrar todos los departamentos
    @GetMapping("/list")
    public String listarDepartamentos (Model model){
        List<Departamento> departamentos = departamentoRepository.findAll();
        model.addAttribute("departamentos", departamentos);
        return "departamentos/listar";
    }
    
    // Mostrar los municipios por departamentos
    @GetMapping("/{id}/municipios")
    public String listarMunicipiosPorDepartamento(@PathVariable Long id, Model model) {
        Departamento departamento = departamentoRepository.findById(id).orElseThrow();
        List<Municipio> municipios = municipioRepository.findByDepartamento(departamento);
        model.addAttribute("departamento", departamento);
        model.addAttribute("municipios", municipios);
        return "municipios/listar";
    }

    
    // Crear Departamento
    @GetMapping("/crear")
    public String crearDepartamentoForm (Model model){
        model.addAttribute("departamento", new Departamento());
        return "departamentos/crear";
    }
    
    @PostMapping("/crear")
    public String crearDepartamento(@ModelAttribute Departamento departamento){
        departamentoRepository.save(departamento);
        return "redirect:/departamentos/list";
    }
    
    // Modificar Departamento
    @GetMapping("/modificar/{id}")
    public String modificarDepartamentoForm(@PathVariable Long id, Model model){
        Departamento departamento = departamentoRepository.findById(id).orElseThrow();
        model.addAttribute("departamento", departamento);
        return "departamentos/modificar";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificarDepartamento (@PathVariable Long id, @ModelAttribute Departamento departamento){
        departamento.setId(id);
        departamentoRepository.save(departamento);
        return "redirect:/departamentos/list";
    }
    
    // Eliminar Departamento
    @GetMapping("eliminar/{id}")
    public String eliminarDepartamento(@PathVariable Long id){
        departamentoRepository.deleteById(id);
        return "redirect:/departamentos/list";
    }
}
