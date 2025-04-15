package com.nayg.dominio;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
@ToString
public final class Jogador {
    private final Integer id;
    private final String nome;
    private final Integer idade;
    private final String posicao;
}
