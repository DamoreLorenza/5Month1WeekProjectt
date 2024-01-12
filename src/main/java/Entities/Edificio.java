package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "edificio")
@NoArgsConstructor
public class Edificio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID uuid;
    @Column(name = "nome")
        private String nome;
    @Column(name = "indirizzo")
        private String indirizzo;
    @Column(name = "citta")
        private String citta;


    @OneToMany(mappedBy = "edificio")
    @Column(name = "postazione")
    private Edificio edificio;

    @OneToMany(mappedBy = "edificio")
    @Column(name = "utente")
    private Utente utente;

    @Override
    public String toString() {
        return "Edificio{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
