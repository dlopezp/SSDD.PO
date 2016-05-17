package nomeolvides.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nomeolvides.entities.Lista;
import nomeolvides.repository.ListaRepository;

@RestController
public class ListController {

	@Autowired
	private ListaRepository listaRepository;

	private static Log log = LogFactory.getLog(ListController.class);

	// obtener todas las listas de un usuario
	@RequestMapping(value = "/listas", method = RequestMethod.GET)
	public List<Lista> getListasByUser(@RequestParam(value = "user") String user) {
		log.info("GET /listas" + " -> from user: " + user);
		return listaRepository.findByUser(user);
	}

	// Obtener todas las listas de un usuario dado con el mismo nombre

	// Dar de alta una lista nueva
	@RequestMapping(value = "/listas", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addLista(@RequestBody Lista lista) {
		try {
			Lista l = listaRepository.save(lista);
			log.info("POST /listas -> id " + l.getId() + " added");
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} catch (Exception e) {

		}
		return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}


	// Modificar una lista ya existente
	@RequestMapping(value = "/lista/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateList(@PathVariable Long id, @RequestBody Lista lista) {
		try {
			if (listaRepository.exists(id)) {
				Lista l = lista;
				l.setId(id);
				listaRepository.save(l);
				log.info("PUT /lista/" + id + " -> id:" + l.getId() + " updated");
				return new ResponseEntity<Boolean>(HttpStatus.OK);
			}
		} catch (Exception e) {
			log.info("PUT /lista/" + id + " -> not updated");
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		log.info("PUT /lista/" + id + " -> not updated");
		return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

	// borrar una lista dado su id
	@RequestMapping(value = "/lista/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteList(@PathVariable Long id) {
		try {
			listaRepository.findOne(id);
			if (listaRepository.exists(id)) {
				listaRepository.delete(listaRepository.findOne(id));
				log.info("DELETE /lista/" + id + " -> id " + id + " deleted");
				return new ResponseEntity<Boolean>(HttpStatus.OK);
			}

		} catch (Exception e) {
			log.info("DELETE /lista/" + id + " -> not deleted");
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		log.info("DELETE /lista/" + id + " -> not deleted");
		return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);

	}

}
