package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "utente")
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
}
