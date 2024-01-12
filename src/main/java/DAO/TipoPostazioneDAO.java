package DAO;

import Entities.TipoPostazione;
import Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoPostazioneDAO extends JpaRepository<TipoPostazione, UUID> {
}
