package com.nayg.service;

import com.nayg.dominio.Jogador;
import com.nayg.repository.JogadorRepository;

public class JogadorService {
    public static void save(Jogador jogador) {
        JogadorRepository.saveJogador(jogador);
    }

    public static void delete(Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }

        JogadorRepository.deleteJogador(id);
    }
}
