package com.flashcard.controller;


import com.flashcard.model.Flashcard;
import com.flashcard.service.FlashcardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping
    public List<Flashcard> listarTodos() {
        return flashcardService.listarFlashcards();
    }

    @PostMapping
    public Flashcard criarFlashcard(@RequestBody Flashcard flashcard) {
        return flashcardService.salvarFlashcard(flashcard);
    }

    @GetMapping("/{id}")
    public Flashcard buscarPorId(@PathVariable Long id) {
        return flashcardService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFlashcard(@PathVariable Long id) {
        flashcardService.deletarFlashcard(id);
    }
}
