package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "edificio")
@Getter
@Setter
@AllArgsConstructor
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

    public Edificio(String nome, String indirizzo, String citta){

        this.nome= nome;
        this.indirizzo=indirizzo;
        this.citta= citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }


    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

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
