package com.ads02.desafioADS.controllers;

import com.ads02.desafioADS.models.LivroModel;
import com.ads02.desafioADS.models.UsuarioModel;
import com.ads02.desafioADS.repository.LivroRepository;
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
@RequestMapping(value = "/livro")
public class LivroController {
    LivroRepository repository = new LivroRepository();
    LivroModel livroModel = new LivroModel();
    @GetMapping(value = "/home")
    public String home() {
        return "formLivro";
    }
    @GetMapping(value = "/lista")
    public ModelAndView listaLivro() throws SQLException {
        ModelAndView mv =new ModelAndView("listaLivro");
        mv.addObject("livros", repository.consultar());
        return mv;
    }
    @PostMapping(value = "/home")
    public String salvar(LivroModel livro) throws SQLException {
        repository.inserir(livro);
        return "redirect:/livro/lista";
    }
}
