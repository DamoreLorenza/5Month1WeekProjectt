package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "prenotazione")
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

        public Prenotazione(){
                this.dataPrenotazione=dataPrenotazione;
        }

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
