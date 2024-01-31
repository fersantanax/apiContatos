package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

public class Contato {

	private UUID id;
	private String nome;
	private List<Categoria> categoria;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

}
