package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "postazione")
@NoArgsConstructor
public class Postazione {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID uuid;
        @Column(name = "codice_univoco")
        private String codiceUnivoco;
        @Column(name = "descrizione")
        private String descrizione;
        @Enumerated(EnumType.STRING)
        @Column(name = "tipo_postazione")
        private TipoPostazione tipo;
        @Column(name = "numero_massimo_occupanti")
        private int numeroMassimoOccupanti;

        @ManyToOne
        @JoinColumn(name = "edificio")
        private Edificio edificio;

        @OneToOne(mappedBy = "prenotazione")
        private Prenotazione prenotazione;

        @OneToMany(mappedBy = "postazione")
        @Column(name = "utente")
        private Utente utente;


        @Override
        public String toString() {
                return "Postazione{" +
                        "uuid=" + uuid +
                        ", codiceUnivoco='" + codiceUnivoco + '\'' +
                        ", descrizione='" + descrizione + '\'' +
                        ", tipo=" + tipo +
                        ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                        ", edificio=" + edificio +
                        '}';
        }
}
