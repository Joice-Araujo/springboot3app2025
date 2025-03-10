package br.gov.sp.fatec.springboot3app2025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3app2025.UsuarioService;
import br.gov.sp.fatec.springboot3app2025.entity.Usuario;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listarTodos(){

        return service.listarTodos();
    }

    @PostMapping
    public Usuario novo(@RequestBody Usuario usuario) {
        return service.novo(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    
    
}
