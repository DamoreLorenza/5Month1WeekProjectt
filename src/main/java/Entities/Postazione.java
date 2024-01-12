package Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
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

        public Postazione() {
        }

        public UUID getUuid() {
                return uuid;
        }

        public String getCodiceUnivoco() {
                return codiceUnivoco;
        }

        public void setCodiceUnivoco(String codiceUnivoco) {
                this.codiceUnivoco = codiceUnivoco;
        }


        public String getDescrizione() {
                return descrizione;
        }

        public void setDescrizione(String descrizione) {
                this.descrizione = descrizione;
        }


        public TipoPostazione getTipo() {
                return tipo;
        }

        public void setTipo(TipoPostazione tipo) {
                this.tipo = tipo;
        }

        public int getNumeroMassimoOccupanti() {
                return numeroMassimoOccupanti;
        }

        public void setNumeroMassimoOccupanti(int numeroMassimoOccupanti) {
                this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        }


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
