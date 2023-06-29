package com.example.taller.repositorios;

import com.example.taller.entidades.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercanciaRepoitorio extends JpaRepository<Mercancia, Integer> {
}
