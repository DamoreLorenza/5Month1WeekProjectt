package DAO;

import Entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, UUID> {
}
