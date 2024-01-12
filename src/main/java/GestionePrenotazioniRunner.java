import DAO.EdificioDAO;
import DAO.PostazioneDAO;
import DAO.PrenotazioneDAO;
import DAO.UtenteDAO;
import Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    public void UtenteConPrenotazione2() {
        Utente utente = new Utente();
        utente.setUsername("CiaoCiaone");
        utente.setNomeCompleto("Ciao Ciaone");
        utente.setEmail("ciaociaone@gmail.com");
        utenteDAO.save(utente);

        Postazione postazione = new Postazione();
        postazione.setCodiceUnivoco("NonSo1");
        postazione.setDescrizione("Zona 2");
        postazione.setTipo(TipoPostazione.OPENSPACE);
        postazione.setNumeroMassimoOccupanti(1);
        postazione.setEdificio(EdificioOne());
        postazioneDAO.save(postazione);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(LocalDate.now());
        prenotazioneDAO.save(prenotazione);
    }

    private Edificio EdificioOne() {
        Edificio edificio = edificioDAO.findByNome("zona2");

        if (edificio == null) {
            edificio = new Edificio();
            edificio.setNome("Empire");
            edificio.setIndirizzo("dietro all'angolo");
            edificio.setCitta("nei miei sogni");
            edificioDAO.save(edificio);
        }

        return edificio;
    }

}
