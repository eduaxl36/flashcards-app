package com.flashcard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pergunta;
    private String resposta;

    @ElementCollection
    private Set<String> tags = new HashSet<>();

 
    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    // Campos de auditoria (simples)
    private LocalDateTime criadoEm = LocalDateTime.now();
    private LocalDateTime atualizadoEm;

    @PreUpdate
    void onUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }

   
}
