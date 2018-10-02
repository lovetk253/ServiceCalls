/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.repository;

import org.demo.entity.Technicians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa repository for Technicians.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Repository
public interface TechniciansRepository  extends JpaRepository<Technicians, Integer> {}