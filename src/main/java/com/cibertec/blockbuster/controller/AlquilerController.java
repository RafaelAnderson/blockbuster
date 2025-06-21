package com.cibertec.blockbuster.controller;

import com.cibertec.blockbuster.forms.AlquilerForm;
import com.cibertec.blockbuster.model.Pelicula;
import com.cibertec.blockbuster.service.AlquilerService;
import com.cibertec.blockbuster.service.ClienteService;
import com.cibertec.blockbuster.service.PeliculaService;
import com.cibertec.blockbuster.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AlquilerController {

    private final ClienteService clienteService;
    private final PeliculaService peliculaService;
    private final AlquilerService alquilerService;

    @GetMapping("/alquiler")
    public String mostrarAlquilerForm(Model model) {
        this.almacenarDataInicial(model);

        return "alquiler-form";
    }

    @PostMapping("/alquiler")
    public String guardarAlquilerForm(Model model, @ModelAttribute("alquiler_form") AlquilerForm form) throws JsonProcessingException {

        Pelicula pelicula = peliculaService.buscarPorId(form.getPelicula().getId());
        int cantStockPelicula = pelicula.getStock();
        int cantSolicitada = form.getCantidad();

        if (cantSolicitada > cantStockPelicula) {
            form.setCantidad(1);
            model.addAttribute("error", "No hay suficientes películas en stock");
            model.addAttribute("alquiler_form", form);
            this.almacenarDataInicial(model);
            return "alquiler-form";
        }

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("form: " + mapper.writeValueAsString(form));

        alquilerService.guardarAlquiler(form);
        peliculaService.actualizarPelicula(form);

        model.addAttribute("mensaje", "¡Alquiler registrado con éxito!");
        model.addAttribute("alquiler_form", new AlquilerForm());
        this.almacenarDataInicial(model);

        return "alquiler-form";
    }


    private void almacenarDataInicial(Model model) {
        if (!model.containsAttribute("alquiler_form")) {
            model.addAttribute("alquiler_form", new AlquilerForm());
        }
        model.addAttribute("precio_alquiler", Constants.PRECIO_ALQUILER);
        model.addAttribute("clientes_list", clienteService.listar());
        model.addAttribute("peliculas_list", peliculaService.listar());
    }
}
