package com.flashcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.model.Flashcard;
import com.flashcard.repository.DeckRepository;
import com.flashcard.repository.FlashcardRepository;

@Service
public class FlashcardService {
	
	@Autowired
	private  FlashcardRepository flashcardRepository;

	public List<Flashcard> listarFlashcards() {
		
		return flashcardRepository.findAll();
	}

	public Flashcard salvarFlashcard(Flashcard flashcard) {
	
		return flashcardRepository.save(flashcard);
	
	}

	public Flashcard buscarPorId(Long id) {
	    return flashcardRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Flashcard não encontrado com id: " + id));
	}


	public void deletarFlashcard(Long id) {
		flashcardRepository.deleteById(id);
		
	}

	  

}
