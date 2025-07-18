package com.flashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.model.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

}
