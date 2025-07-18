package com.flashcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.model.Deck;
import com.flashcard.repository.DeckRepository;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    public List<Deck> listarDecks() {
        return deckRepository.findAll();
    }

    public Deck salvarDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public Deck buscarPorId(Long id) {
        return deckRepository.findById(id).orElseThrow();
    }

    public void deletarDeck(Long id) {
        deckRepository.deleteById(id);
    }
}
