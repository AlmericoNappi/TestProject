package com.dao;

import com.model.Cittadini;

public interface CittadiniDao {

	public void save(Cittadini c);
	public void update(Cittadini c);
	public void delete(int id);
	public Cittadini findByCodiceFiscale(String codFisc);

	
}
