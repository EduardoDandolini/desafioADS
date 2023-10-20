package com.ads02.desafioADS.controllers;

import com.ads02.desafioADS.models.UsuarioModel;
import com.ads02.desafioADS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
    UsuarioRepository repository = new UsuarioRepository();
    UsuarioModel usuarioModel = new UsuarioModel();
    @GetMapping(value = "/home")
    public String home() {
        return "formUsuario";
    }
    @GetMapping(value = "/lista")
    public ModelAndView listaUsuario() throws SQLException {
        ModelAndView mv =new ModelAndView("listaUsuario");
        mv.addObject("usuarios", repository.consultar());
        return mv;
    }
    @PostMapping(value = "/home")
    public String salvar(UsuarioModel usario) throws SQLException {
        repository.inserir(usario);
        return "redirect:/usuario/lista";
    }

}
