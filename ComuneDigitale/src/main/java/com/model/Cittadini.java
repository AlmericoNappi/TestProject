package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Cittadini.findAll", query="SELECT c FROM Cittadini c")
public class Cittadini implements Serializable{
		private static final long serialVersionUID = 1L;
		

		@Id
		private int id;
		
		@Column(name="CODICE_FISCALE")
		private String codiceFiscale;
		
		private String Cognome;
		
		@Temporal(TemporalType.DATE)
		@Column(name="DATA_NASCITA")
		private Date dataNascita;
		
		private String nome;


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
			return Cognome;
		}

		public void setCognome(String cognome) {
			Cognome = cognome;
		}

		public Date getDataNascita() {
			return dataNascita;
		}

		public void setDataNascita(Date dataNascita) {
			this.dataNascita = dataNascita;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}


		



}

