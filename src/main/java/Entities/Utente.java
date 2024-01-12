package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;



//ho messo i get e i set nonostante i @setter e @getter che non so perchè non me li legge, qualcosa mi sfugge. mentre @noargsconstructor in automatico mi da il constructor che io non ho messo e mi setgnala che serve. percui non capisco perchè non mi legge nulla. idem per le altre entities

@Entity
@Table(name = "utente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID uuid;
    @Column(name = "username")
        private String username;
    @Column(name = "nome_completo")
        private String nomeCompleto;
    @Column(name = "email")
        private String email;

    @OneToMany(mappedBy = "utente")
    @Column(name = "prenotazione")
    private Prenotazione prenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "edificio")
    private Edificio edificio;

public Utente(String username, String nomeCompleto, String email){
    this.username=username;
    this.nomeCompleto=nomeCompleto;
    this.email=email;
}



    @Override
    public String toString() {
        return "Utente{" +
                "uuid=" + uuid +
                ", username='" + username + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public UUID getUuid() {
        return uuid;
    }
}
