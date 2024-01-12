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


    }
