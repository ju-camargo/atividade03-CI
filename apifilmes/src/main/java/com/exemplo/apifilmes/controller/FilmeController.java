package com.exemplo.apifilmes.controller;

import com.exemplo.apifilmes.model.Filme;
import com.exemplo.apifilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repo;

    @GetMapping
    public List<Filme> listarFilmes() {
        return repo.findAll();
    }

    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme f) {
        return repo.save(f);
    }
}