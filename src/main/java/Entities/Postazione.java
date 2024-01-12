package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "postazione")
@Getter
@Setter
@AllArgsConstructor
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

        public Postazione (String codiceUnivoco, String descrizione, TipoPostazione tipo, int numeroMassimoOccupanti){
                this.codiceUnivoco= codiceUnivoco;
                this.descrizione=descrizione;
                this.tipo= tipo;
                this.numeroMassimoOccupanti=numeroMassimoOccupanti;
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

        public Edificio getEdificio() {
                return edificio;
        }

        public void setEdificio(Edificio edificio) {
                this.edificio = edificio;
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
