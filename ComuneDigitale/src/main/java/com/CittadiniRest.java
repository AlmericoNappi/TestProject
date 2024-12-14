package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CittadiniDao;
import com.dao.DipendentiDao;
import com.dao.impl.CittadiniDaoImpl;
import com.dao.impl.DipendentiDaoImpl;
import com.model.Cittadini;
import com.util.CittadiniWrapper;

@RestController
@RequestMapping("/cittadino")
public class CittadiniRest {

	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Cittadini c) {
		CittadiniDao cDao = new CittadiniDaoImpl();
		cDao.save(c);
		
		
		return new ResponseEntity<String>(
			      "Inserimento Effettuato",  HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody CittadiniWrapper c) {
		
		DipendentiDao dDao = new DipendentiDaoImpl();		
		CittadiniDao cDao = new CittadiniDaoImpl();
		
		boolean res = dDao.login(c.getUser(), c.getPwd());
		if(res) {
			cDao.update(c.getCittadino());
			return new ResponseEntity<String>(
				      "Inserimento Effettuato",  HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(
				      "Credenziali errate",  HttpStatus.FORBIDDEN);
		}

	}
	
	@GetMapping
	public ResponseEntity<Cittadini> findByFiscalCode(@RequestParam String username,@RequestParam String pwd, @RequestParam String codFisc) {

		Cittadini c = new Cittadini();
		DipendentiDao dDao = new DipendentiDaoImpl();		
		CittadiniDao cDao = new CittadiniDaoImpl();
		
		boolean res = dDao.login(username, pwd);
		if(res) {
			 c  = cDao.findByCodiceFiscale(codFisc);
			 
			 System.out.println("id:"+c.getId());
			 return new ResponseEntity<Cittadini>(c, HttpStatus.OK);
		}
		else
			return  new ResponseEntity<Cittadini>(c, HttpStatus.FORBIDDEN);

	}
	
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestBody CittadiniWrapper c){
		DipendentiDao dDao = new DipendentiDaoImpl();		
		CittadiniDao cDao = new CittadiniDaoImpl();
		
		boolean res = dDao.login(c.getUser(), c.getPwd());
		if(res) {
			cDao.delete(c.getCittadino().getId());
			return new ResponseEntity<String>(
				      "Eliminazione Effettuata",  HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(
				      "Credenziali errate",  HttpStatus.FORBIDDEN);
		}

	}

}
