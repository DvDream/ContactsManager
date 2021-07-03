package com.spring.datajpa.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.datajpa.model.Contact;
import com.spring.datajpa.repository.ContactRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ContactController{

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts(@RequestParam(required = false) String keyword) {
		try {
			List<Contact> contact = new ArrayList<Contact>();

			if (keyword == null)
				contactRepository.findAll().forEach(contact::add);
			else
				contactRepository.full_search(keyword).forEach(contact::add);
				//tutorialRepository.findByNameContaining(name).forEach(tutorials::add);
			if (contact.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getTutorialById(@PathVariable("id") long id) {
		Optional<Contact> contactData = contactRepository.findById(id);

		if (contactData.isPresent()) {
			return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/contacts")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
		try {
			Contact _contact = contactRepository
					.save(new Contact(contact.getSurname(), contact.getName(), contact.getPhone_number(),contact.getAddress(), contact.getGeo_data(), contact.getOther_info()));
			return new ResponseEntity<>(_contact, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
		Optional<Contact> contactData = contactRepository.findById(id);

		if (contactData.isPresent()) {
			Contact _contact = contactData.get();
			_contact.setSurname(contact.getSurname());
			_contact.setName(contact.getName());
			_contact.setPhone_number(contact.getPhone_number());
			_contact.setAddress(contact.getAddress());
			_contact.setGeo_data(contact.getGeo_data());
			_contact.setOther_info(contact.getOther_info());
			return new ResponseEntity<>(contactRepository.save(_contact), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
		try {
			contactRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/contacts")
	public ResponseEntity<HttpStatus> deleteAllContacts() {
		try {
			contactRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

/*	@GetMapping("/tutorials/{keyword}")
	public ResponseEntity<List<Tutorial>> full_search(@PathVariable("keyword") String keyword){
		try {
			List<Tutorial> tutorials = tutorialRepository.full_search(keyword);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
/*	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		try {
			List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/

}
