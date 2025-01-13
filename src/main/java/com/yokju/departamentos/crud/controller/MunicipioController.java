
package com.yokju.departamentos.crud.controller;

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
@RequestMapping("/municipios")
public class MunicipioController {

    @Autowired
    private MunicipioRepository municipioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    // Crear Municipio
    @GetMapping("/crear")
    public String crearMunicipioForm(Model model) {
        model.addAttribute("municipio", new Municipio());
        model.addAttribute("departamentos", departamentoRepository.findAll());
        return "municipios/crear";
    }

    @PostMapping("/crear")
    public String crearMunicipio(@ModelAttribute Municipio municipio) {
        municipioRepository.save(municipio);
        return "redirect:/municipios/list";
    }

    // Mostrar todos los municipios
    @GetMapping("/list")
    public String listarMunicipios(Model model) {
        List<Municipio> municipios = municipioRepository.findAll();
        model.addAttribute("municipios", municipios);
        return "municipios/listarTodos";
    }
    

    // Modificar Municipio
    @GetMapping("/modificar/{id}")
    public String modificarMunicipioForm(@PathVariable Long id, Model model) {
        Municipio municipio = municipioRepository.findById(id).orElseThrow();
        model.addAttribute("municipio", municipio);
        model.addAttribute("departamentos", departamentoRepository.findAll());
        return "municipios/modificar";
    }

    @PostMapping("/modificar/{id}")
    public String modificarMunicipio(@PathVariable Long id, @ModelAttribute Municipio municipio) {
        municipio.setId(id);
        municipioRepository.save(municipio);
        return "redirect:/municipios/list";
    }

    // Eliminar Municipio
    @GetMapping("/eliminar/{id}")
    public String eliminarMunicipio(@PathVariable Long id) {
        municipioRepository.deleteById(id);
        return "redirect:/municipios/list";
    }
}