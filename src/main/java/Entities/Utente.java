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
        private String username;
        private String nomeCompleto;
        private String email;



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
