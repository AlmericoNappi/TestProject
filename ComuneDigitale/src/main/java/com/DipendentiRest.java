package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.DipendentiDao;
import com.dao.impl.DipendentiDaoImpl;
import com.model.Dipendenti;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/dipendente")
@Api(value="DipendentiRest", tags="Servizio Rest Per I Dipendenti ")
public class DipendentiRest {

	@ApiOperation(
		      value = "Registrazione Nuovo Dipendente", 
		      notes = "Permette la Registrazione di un Nuovo Dipendente",
		      response = String.class, 
		      produces = "application/json")
	@ApiResponses(value =
	{   @ApiResponse(code = 200, message = "Inserimento Effettuato!")
	})
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Dipendenti d) {
		DipendentiDao dDao = new DipendentiDaoImpl();
		dDao.save(d);
		
		
		return new ResponseEntity<String>(
			      "Inserimento Effettuato",  HttpStatus.OK);
	}
}
