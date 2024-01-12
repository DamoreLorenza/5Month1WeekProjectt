package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "prenotazione")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID uuid;
        @Column(name = "data_prenotazione")
        private LocalDate dataPrenotazione;

        @ManyToOne
        @JoinColumn(name = "utente")
        private Utente utente;

        @OneToOne
        @JoinColumn(name = "postazione")
        private Postazione postazione;


        @Override
        public String toString() {
                return "Prenotazione{" +
                        "uuid=" + uuid +
                        ", dataPrenotazione=" + dataPrenotazione +
                        ", utente=" + utente +
                        ", postazione=" + postazione +
                        '}';
        }

        public void setUtente(Utente utente) {
        }


        public void setPostazione(Postazione postazione) {
        }

        public void setDataPrenotazione(LocalDate dataPrenotazione) {
        }
}
