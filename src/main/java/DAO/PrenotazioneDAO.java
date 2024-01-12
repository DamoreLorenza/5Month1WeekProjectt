package DAO;

import Entities.Postazione;
import Entities.Prenotazione;
import Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, UUID> {
    boolean PostazioneEDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
    boolean UtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
}
