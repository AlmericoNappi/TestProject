package com.dao;

import com.model.Dipendenti;

public interface DipendentiDao {

	public void save(Dipendenti c);
	public boolean login(String user, String pwd);
	
	
}
