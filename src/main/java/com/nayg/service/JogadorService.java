package com.nayg.service;

import com.nayg.dominio.Jogador;
import com.nayg.repository.JogadorRepository;

public class JogadorService {
    public static void save(Jogador jogador) {
        JogadorRepository.saveJogador(jogador);
    }
}
