/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:57 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;



import java.util.List;

import javax.transaction.Transactional;

import org.demo.entity.Customers;
import org.demo.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public Customers getOne(Integer customerId) {
		return customersRepository.findById(customerId).get();
	}

	@Override
	public Boolean delete(Integer customerId) {
		if (customersRepository.getOne(customerId) != null) {
			customersRepository.deleteById(customerId);
			return true;
		}
		return false;
	}

	@Override
	public Customers create(Customers customers) {
		return customersRepository.save(customers);
	}

	@Override
	public Customers update(Customers customersToUpdate) {
						Customers customers = customersRepository.getOne(customersToUpdate.getCustomerId());
																		
				if(customersToUpdate.getCustomerName() !=null) {
			
		}
				if(customersToUpdate.getCustomerAddress() !=null) {
			
		}
				if(customersToUpdate.getOtherDetails() !=null) {
			
		}
				return customersRepository.save(customers);
	}

	@Override
	public Boolean exist(Customers customers) {
						return customersRepository.existsById(customers.getCustomerId());
																	}

	@Override
	public List<Customers> findAll() {
		return customersRepository.findAll();
	}

}


