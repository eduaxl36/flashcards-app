package com.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
