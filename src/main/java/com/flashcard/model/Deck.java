package com.flashcard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;

	// Relacionamento: um deck para muitos flashcards
	@OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Flashcard> flashcards = new HashSet<>();

	private LocalDateTime criadoEm = LocalDateTime.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(Set<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Deck() {
		super();
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", flashcards=" + flashcards
				+ ", criadoEm=" + criadoEm + "]";
	}
	
	
	
	

}
