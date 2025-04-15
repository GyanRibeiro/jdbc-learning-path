package com.nayg.repository;

import com.nayg.conn.ConnectionFactory;
import com.nayg.dominio.Jogador;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class JogadorRepository {
    public static void saveJogador(Jogador jogador) {
        String sql = "INSERT INTO public.jogadores (nome, idade, posição) VALUES ('%s', '%d', '%s');".formatted(jogador.getNome(), jogador.getIdade(), jogador.getPosicao());

        try (Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted jogador '{}' in the database, rows affected: '{}'", jogador.getNome(), rowsAffected);
        }
        catch (SQLException e) {
            log.error("Error inserting jogador '{}'", jogador.getNome(), e);
            System.out.println(e.getMessage());;
        }
    }

    public static void deleteJogador(int id) {
        String sql = "DELETE FROM public.jogadores WHERE (id = '%d');".formatted(id);

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted jogador '{}' in the database, rows affected: '{}'", id, rowsAffected);
        }
        catch (SQLException e) {
            log.error("Error delete jogador '{}'", id, e);
            System.out.println(e.getMessage());;
        }
    }
}
