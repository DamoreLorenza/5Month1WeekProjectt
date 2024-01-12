package DAO;

import Entities.Edificio;
import Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificioDAO extends JpaRepository<Edificio, UUID>{
}
