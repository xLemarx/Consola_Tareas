package com.easysystems.modelo;

public class Tarea {
	private String titulo;
	private String descripcion;
	private Boolean completada;
	private String categoria;
	
	public Tarea(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = "";
		this.completada = false;
	}
	
	public Tarea(String titulo, String descripcion, String categoria) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.completada = false;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getCompletada() {
		return completada;
	}

	public void completar() {
		this.completada = true;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return (completada ? "[X]" : "[ ]") + " " + this.titulo + " " + this.descripcion + " " + this.categoria ;
	}
	
}
