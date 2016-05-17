package nomeolvides.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nomeolvides.entities.Lista;
import nomeolvides.repository.ListaRepository;

@RestController
public class ListController {

	@Autowired
	private ListaRepository listaRepository;

	private static Log log = LogFactory.getLog(ListController.class);

	
	// obtener todas las listas de un usuario
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public List<Lista> getListasByUser(@RequestParam(value = "user") String user) {
		log.info("GET /lista" + "-> user:" + user);
		return listaRepository.findByUser(user);
	}


	// Dar de alta una lista nueva
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addLista(@RequestBody Lista lista) {
		log.info("POST /lista" + "-> list name:" + lista.getName());
		return null;

	}

	// Obtener todas las listas de un usuario dado con el mismo nombre

	// Modificar una lista ya existente
	@RequestMapping(value = "/lista/{name}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateList(@PathVariable String name, @RequestBody Lista lista) {
		log.info("PUT /lista/" + name + lista.getName());
		try {
			Lista l = lista;
			l.setName(name);
			listaRepository.save(l);
		} catch (Exception e) {
			log.error("PUT /lista/->" + name + e.getMessage());
		}
		return null;
	}

	// borrar una lista dado su id
	@RequestMapping(value = "/lista/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteList(@PathVariable Long id) {
		return null;
	}

}
