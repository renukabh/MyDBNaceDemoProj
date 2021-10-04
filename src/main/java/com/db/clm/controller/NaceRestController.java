package com.db.clm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.clm.model.Nace;
import com.db.clm.service.NaceService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
class NaceRestController {
	@Autowired
	NaceService naceService;

	// creating a get mapping that retrieves all the nace detail from the database
	@GetMapping("/getAllnace")
	public ResponseEntity<List<Nace>> getAllNaceList() {
		try {
			List<Nace> list = naceService.getAllnacelist();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// creating a get mapping that retrieves the detail of a specific nace
	@GetMapping("/getNace/{naceorder}")
	public ResponseEntity<Nace> getNaceByOrder(@PathVariable("naceorder") int order) {
		try {

			return new ResponseEntity<Nace>(naceService.getNaceByOrder(order), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Nace>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/*
	 * // creating a delete mapping that deletes a specified nace
	 * 
	 * @DeleteMapping("/deleteNace/{naceorder}") private ResponseEntity<HttpStatus>
	 * deleteNace(@PathVariable("naceorder") int order) {
	 * 
	 * try { Optional<Nace> nace = Optional.of(naceService.getNaceByOrder(order));
	 * if (nace.isPresent()) { naceService.delete(order); } return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	// creating post mapping that post the nace detail in the database
	@PostMapping("/createNace")
	public ResponseEntity<Nace> saveNace(@RequestBody Nace nace) {
		try {
			return new ResponseEntity<>(naceService.saveOrUpdate(nace), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// creating put mapping that updates the book detail
	@PutMapping("/updateNace")
	private ResponseEntity<Nace> update(@RequestBody Nace nace) {

		try {
			return new ResponseEntity<>(naceService.update(nace), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
