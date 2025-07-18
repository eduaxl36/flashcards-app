package com.flashcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.model.Deck;
import com.flashcard.service.DeckService;

@RestController
@RequestMapping("/decks")
public class DeckController {
    
	@Autowired
    private DeckService deckService;
    
	
    @GetMapping
    public List<Deck> listarTodos() {
        return deckService.listarDecks();
    }

    @PostMapping
    public Deck criarDeck(@RequestBody Deck deck) {
        return deckService.salvarDeck(deck);
    }

    @GetMapping("/{id}")
    public Deck buscarPorId(@PathVariable Long id) {
        return deckService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDeck(@PathVariable Long id) {
        deckService.deletarDeck(id);
    }
	
    
    
}
