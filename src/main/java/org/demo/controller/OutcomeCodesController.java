/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.OutcomeCodes;
import org.demo.service.OutcomeCodesServiceImpl;

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
@RequestMapping(value = "/outcomeCodes", produces = "application/hal+json")
public class OutcomeCodesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OutcomeCodesController.class);

	private static final String NOT_FOUND ="OutcomeCodes not found";

	@Autowired
	private OutcomeCodesServiceImpl outcomeCodesService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<OutcomeCodes> findAll() {
		List<OutcomeCodes> list = outcomeCodesService.findAll();
		return list;
	}


	@GetMapping("{outcomeCodes}")
	public OutcomeCodes get(@PathVariable("outcomeCodes") Integer outcomeCodes) {
		final OutcomeCodes outcomeCode = outcomeCodesService.getOne(outcomeCodes);
		LOGGER.info("OutcomeCodes found : {}", outcomeCodes);
		return outcomeCode;
	}

	@PostMapping(consumes = "application/json")
	public OutcomeCodes create(@RequestBody OutcomeCodes outcomeCodes) {
		LOGGER.info("OutcomeCodes creation request : {}", outcomeCodes);
		if (outcomeCodesService.exist(outcomeCodes)) {
			LOGGER.info("OutcomeCodes already exist ! : {}", outcomeCodes);
			return null;
		} else {
			final OutcomeCodes created = outcomeCodesService.create(outcomeCodes);
			LOGGER.info("Created outcomeCodes {}", created);
			return created;
		}
	}

	@PutMapping(value = "{outcomeCodes}", consumes = "application/json")
	public OutcomeCodes update(@PathVariable("outcomeCodes") Integer outcomeCodes, @RequestBody OutcomeCodes outcomeCode) {
		return outcomeCodesService.update(outcomeCode);
	}

	@DeleteMapping("{outcomeCodes}")
	public void delete(@PathVariable("outcomeCodes") Integer outcomeCodes) {
		LOGGER.info("OutcomeCodes deletion request : {}", resolveIdForLogger(outcomeCodes));
		if (outcomeCodesService.delete(outcomeCodes)) {
			LOGGER.info("OutcomeCodes successfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer outcomeCodes) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(outcomeCodes));
		return ids.toString();
	}

}

