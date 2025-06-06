package com.nayg.repository;

import com.nayg.conn.ConnectionFactory;
import com.nayg.dominio.Jogador;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class JogadorRepository {
    public static void saveJogador(Jogador jogador) {
        String sql = "INSERT INTO public.jogadores (nome, idade, posicao) VALUES ('%s', '%d', '%s');".formatted(jogador.getNome(), jogador.getIdade(), jogador.getPosicao());

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

    public static void updateJogador(Jogador jogador) {
        String sql = "UPDATE public.jogadores SET posicao = '%s' WHERE id = '%d';".formatted(jogador.getPosicao(), jogador.getId());

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Update jogador '{}' in the database, rows affected: '{}'", jogador.getId(), rowsAffected);
        }
        catch (SQLException e) {
            log.error("Error update jogador '{}'", jogador.getId(), e);
            System.out.println(e.getMessage());;
        }
    }

    public static List <Jogador> findAll() {
        String sql = "SELECT * FROM public.jogadores";

        log.info("Finding all Jogadores in the database...");

        List<Jogador> jogadores = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {

                jogadores.add(Jogador.builder()
                        .id(rs.getInt("id"))
                        .nome(rs.getString("nome"))
                        .idade(rs.getInt("idade"))
                        .posicao(rs.getString("posicao"))
                        .build()
                );
            }

        }
        catch (SQLException e) {
            log.error("Error while trying find all jogadores", e);
            System.out.println(e.getMessage());;
        }

        return jogadores;
    }
}
