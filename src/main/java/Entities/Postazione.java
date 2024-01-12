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
        private String codiceUnivoco;
        private String descrizione;
        @Enumerated(EnumType.STRING)
        private TipoPostazione tipo;
        private int numeroMassimoOccupanti;

        @ManyToOne
        @JoinColumn(name = "edificio_id")
        private Edificio edificio;



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
