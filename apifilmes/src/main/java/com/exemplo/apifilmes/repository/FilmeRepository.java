package com.exemplo.apifilmes.repository;

import com.exemplo.apifilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {}