package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Dipendenti.findAll", query="SELECT c FROM Dipendenti c")
public class Dipendenti implements Serializable{
		private static final long serialVersionUID = 1L;
		

		@Id
		private int id;
		
		@Column(name="CODICE_FISCALE")
		private String codiceFiscale;
		
		private String cognome;

		private String nome;
		
		private String password;

		public Dipendenti(int id, String codiceFiscale, String cognome, String nome, String password) {
			super();
			this.id = id;
			this.codiceFiscale = codiceFiscale;
			this.cognome = cognome;
			this.nome = nome;
			this.password = password;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
		
		
		
		
}
