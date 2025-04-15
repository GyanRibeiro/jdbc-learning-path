package com.nayg.service;

import com.nayg.dominio.Jogador;
import com.nayg.repository.JogadorRepository;

import java.util.List;

public class JogadorService {
    public static void save(Jogador jogador) {
        JogadorRepository.saveJogador(jogador);
    }

    public static void delete(Integer id) {
        requireValidId(id);

        JogadorRepository.deleteJogador(id);
    }

    public static void update(Jogador jogador) {
        requireValidId(jogador.getId());
        JogadorRepository.updateJogador(jogador);
    }

    public static List <Jogador> findAll() {
        return JogadorRepository.findAll();
    }

    private static void requireValidId(Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
    }
}
