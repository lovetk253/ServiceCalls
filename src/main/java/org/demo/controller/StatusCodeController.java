/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.StatusCode;
import org.demo.service.StatusCodeServiceImpl;

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
@RequestMapping(value = "/statusCode", produces = "application/hal+json")
public class StatusCodeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatusCodeController.class);

	private static final String NOT_FOUND ="StatusCode not found";

	@Autowired
	private StatusCodeServiceImpl statusCodeService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<StatusCode> findAll() {
		List<StatusCode> list = statusCodeService.findAll();
		return list;
	}


	@GetMapping("{statusCode}")
	public StatusCode get(@PathVariable("statusCode") Integer statusCode) {
		final StatusCode statusCodes = statusCodeService.getOne(statusCode);
		LOGGER.info("StatusCode found : {}", statusCode);
		return statusCodes;
	}

	@PostMapping(consumes = "application/json")
	public StatusCode create(@RequestBody StatusCode statusCode) {
		LOGGER.info("StatusCode creation request : {}", statusCode);
		if (statusCodeService.exist(statusCode)) {
			LOGGER.info("StatusCode already exist ! : {}", statusCode);
			return null;
		} else {
			final StatusCode created = statusCodeService.create(statusCode);
			LOGGER.info("Created statusCode {}", created);
			return created;
		}
	}

	@PutMapping(value = "{statusCode}", consumes = "application/json")
	public StatusCode update(@PathVariable("statusCode") Integer statusCode, @RequestBody StatusCode statusCodes) {
		return statusCodeService.update(statusCodes);
	}

	@DeleteMapping("{statusCode}")
	public void delete(@PathVariable("statusCode") Integer statusCode) {
		LOGGER.info("StatusCode deletion request : {}", resolveIdForLogger(statusCode));
		if (statusCodeService.delete(statusCode)) {
			LOGGER.info("StatusCode successfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer statusCode) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(statusCode));
		return ids.toString();
	}

}

