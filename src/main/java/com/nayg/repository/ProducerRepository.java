package com.nayg.repository;

import com.nayg.conn.ConnectionFactory;
import com.nayg.dominio.Jogador;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void saveProducer(Jogador jogador) {
        String sql = "INSERT INTO public.jogadores (nome, idade, posição) VALUES ('%s', '%d', '%s');".formatted(jogador.getNome(), jogador.getIdade(), jogador.getPosicao());

        try (Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database inserted: {}", rowsAffected);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
