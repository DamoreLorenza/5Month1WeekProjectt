import DAO.EdificioDAO;
import DAO.PostazioneDAO;
import DAO.PrenotazioneDAO;
import DAO.UtenteDAO;
import Entities.Postazione;
import Entities.Prenotazione;
import Entities.TipoPostazione;
import Entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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


    public boolean prenotaPostazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        if (PostazioneLibera(postazione, dataPrenotazione)) {
            if (!UtentePrenotazionePerGiorno(utente, dataPrenotazione)) {
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setUtente(utente);
                prenotazione.setPostazione(postazione);
                prenotazione.setDataPrenotazione(dataPrenotazione);
                prenotazioneDAO.save(prenotazione);
                return true;
            } else {
                System.out.println("già prenotato");
                return false;
            }
        } else {
            System.out.println("non disponibile");
            return false;
        }
    }
    private boolean PostazioneLibera(Postazione postazione, LocalDate dataPrenotazione) {
        return !prenotazioneDAO.PostazioneEDataPrenotazione(postazione, dataPrenotazione);
    }

    private boolean UtentePrenotazionePerGiorno(Utente utente, LocalDate dataPrenotazione) {
        return prenotazioneDAO.UtenteAndDataPrenotazione(utente, dataPrenotazione);
    }

    @Override
    public void run(String... args) throws Exception {

        Utente utente = new Utente();
        utente.setUsername("loreUsername");
        utente.setNomeCompleto("Lorenza D'Amore");
        utente.setEmail("lorenzadamore@outlook.it");
        utenteDAO.save(utente);

        Postazione postazione = new Postazione();
        postazione.setCodiceUnivoco("BoH12");
        postazione.setDescrizione("Postazione zona 1");
        postazione.setTipo(TipoPostazione.OPENSPACE);
        postazione.setNumeroMassimoOccupanti(1);
        postazione.setEdificio(edificioDAO.findByNome("zona1"));
        postazioneDAO.save(postazione);



    }
}
