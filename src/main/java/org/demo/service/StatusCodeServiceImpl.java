/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;



import java.util.List;

import javax.transaction.Transactional;

import org.demo.entity.StatusCode;
import org.demo.repository.StatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StatusCodeServiceImpl implements StatusCodeService {

	@Autowired
	private StatusCodeRepository statusCodeRepository;

	@Override
	public StatusCode getOne(Integer statusCode) {
		return statusCodeRepository.findById(statusCode).get();
	}

	@Override
	public Boolean delete(Integer statusCode) {
		if (statusCodeRepository.getOne(statusCode) != null) {
			statusCodeRepository.deleteById(statusCode);
			return true;
		}
		return false;
	}

	@Override
	public StatusCode create(StatusCode statusCode) {
		return statusCodeRepository.save(statusCode);
	}

	@Override
	public StatusCode update(StatusCode statusCodeToUpdate) {
						StatusCode statusCode = statusCodeRepository.getOne(statusCodeToUpdate.getStatusCode());
										
				if(statusCodeToUpdate.getStatusDecription() !=null) {
			
		}
				return statusCodeRepository.save(statusCode);
	}

	@Override
	public Boolean exist(StatusCode statusCode) {
						return statusCodeRepository.existsById(statusCode.getStatusCode());
									}

	@Override
	public List<StatusCode> findAll() {
		return statusCodeRepository.findAll();
	}

}


