import com.nayg.conn.ConnectionFactory;
import com.nayg.dominio.Jogador;
import com.nayg.repository.JogadorRepository;
import com.nayg.service.JogadorService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jogador jg1 = Jogador.builder()
                .nome("Rossi")
                        .idade(31)
                                .posicao("Goleiro")
                                        .build();

        JogadorService.save(jg1);
    }
}