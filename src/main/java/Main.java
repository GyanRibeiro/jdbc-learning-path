import com.nayg.conn.ConnectionFactory;
import com.nayg.dominio.Jogador;
import com.nayg.repository.JogadorRepository;
import com.nayg.service.JogadorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Jogador jg1 = Jogador.builder()
                .nome("Rossi")
                .idade(31)
                .posicao("Goleiro")
                .build();

        Jogador jgUpdate = Jogador.builder()
                .id(4)
                .nome(null)
                .idade(null)
                .posicao("Centroavante")
                .build();

//        JogadorService.save(jg1);
//        JogadorService.delete(5);
//        JogadorService.update(jgUpdate);
        log.info(JogadorService.findAll());
        System.out.println("============================================");
        System.out.println(JogadorService.findAll());
    }
}