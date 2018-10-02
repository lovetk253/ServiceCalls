/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.Customers;
import org.demo.service.CustomersServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/customers", produces = "application/hal+json")
public class CustomersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);

	private static final String NOT_FOUND ="Customers not found";

	@Autowired
	private CustomersServiceImpl customersService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customers> findAll() {
		List<Customers> list = customersService.findAll();
		return list;
	}


	@GetMapping("{customerId}")
	public Customers get(@PathVariable("customerId") Integer customerId) {
		final Customers customers = customersService.getOne(customerId);
		LOGGER.info("Customers found : {}", customers);
		return customers;
	}

	@PostMapping(consumes = "application/json")
	public Customers create(@RequestBody Customers customers) {
		LOGGER.info("Customers creation request : {}", customers);
		if (customersService.exist(customers)) {
			LOGGER.info("Customers already exist ! : {}", customers);
			return null;
		} else {
			final Customers created = customersService.create(customers);
			LOGGER.info("Created customers {}", created);
			return created;
		}
	}

	@PutMapping(value = "{customerId}", consumes = "application/json")
	public Customers update(@PathVariable("customerId") Integer customerId, @RequestBody Customers customers) {
		return customersService.update(customers);
	}

	@DeleteMapping("{customerId}")
	public void delete(@PathVariable("customerId") Integer customerId) {
		LOGGER.info("Customers deletion request : {}", resolveIdForLogger(customerId));
		if (customersService.delete(customerId)) {
			LOGGER.info("Customers successfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer customerId) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(customerId));
		return ids.toString();
	}

}

