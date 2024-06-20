package com.emidiogustavo.workshopmongo.DTO;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private String texto; 
	private Date data; 
	private AuthorDTO author; 
	
	public CommentDTO() {	
	}
	
	public CommentDTO(String texto, Date data, AuthorDTO author) {
		super();
		this.texto = texto;
		this.data = data;
		this.author = author;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
