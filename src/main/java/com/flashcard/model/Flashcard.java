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

	public Flashcard() {
		super();
	}

	@PreUpdate
	void onUpdate() {
		this.atualizadoEm = LocalDateTime.now();
	}

	private String caminhoImagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", pergunta=" + pergunta + ", resposta=" + resposta + ", tags=" + tags
				+ ", deck=" + deck + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + ", caminhoImagem="
				+ caminhoImagem + "]";
	}
	
	

}
