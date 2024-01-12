import DAO.EdificioDAO;
import DAO.PostazioneDAO;
import DAO.PrenotazioneDAO;
import DAO.UtenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class GestionePrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private PostazioneDAO postazioneDAO;

    @Autowired
    private EdificioDAO edificioDAO;

    @Autowired
    private UtenteDAO utenteDAO;

    @Autowired
    private PrenotazioneDAO prenotazioneDAO;



    @Override
    public void run(String... args) throws Exception {

    }
}
