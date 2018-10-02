/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.ChargeCodes;
import org.demo.service.ChargeCodesServiceImpl;

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
@RequestMapping(value = "/chargeCodes", produces = "application/hal+json")
public class ChargeCodesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChargeCodesController.class);

	private static final String NOT_FOUND ="ChargeCodes not found";

	@Autowired
	private ChargeCodesServiceImpl chargeCodesService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ChargeCodes> findAll() {
		List<ChargeCodes> list = chargeCodesService.findAll();
		return list;
	}


	@GetMapping("{chargeCode}")
	public ChargeCodes get(@PathVariable("chargeCode") Integer chargeCode) {
		final ChargeCodes chargeCodes = chargeCodesService.getOne(chargeCode);
		LOGGER.info("ChargeCodes found : {}", chargeCodes);
		return chargeCodes;
	}

	@PostMapping(consumes = "application/json")
	public ChargeCodes create(@RequestBody ChargeCodes chargeCodes) {
		LOGGER.info("ChargeCodes creation request : {}", chargeCodes);
		if (chargeCodesService.exist(chargeCodes)) {
			LOGGER.info("ChargeCodes already exist ! : {}", chargeCodes);
			return null;
		} else {
			final ChargeCodes created = chargeCodesService.create(chargeCodes);
			LOGGER.info("Created chargeCodes {}", created);
			return created;
		}
	}

	@PutMapping(value = "{chargeCode}", consumes = "application/json")
	public ChargeCodes update(@PathVariable("chargeCode") Integer chargeCode, @RequestBody ChargeCodes chargeCodes) {
		return chargeCodesService.update(chargeCodes);
	}

	@DeleteMapping("{chargeCode}")
	public void delete(@PathVariable("chargeCode") Integer chargeCode) {
		LOGGER.info("ChargeCodes deletion request : {}", resolveIdForLogger(chargeCode));
		if (chargeCodesService.delete(chargeCode)) {
			LOGGER.info("ChargeCodes successfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer chargeCode) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(chargeCode));
		return ids.toString();
	}

}

