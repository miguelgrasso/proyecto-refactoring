package com.exercise.developer.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.developer.demo.logvalues.LogValues;
import com.exercise.developer.demo.repository.LogValuesRepository;

@Service("logValuesService")

public class LogValuesServiceImpl implements LogValuesService{
	
	@Autowired
	LogValuesRepository logValuesRepository;
	
	public void saveOrUpdate(LogValues logValues) {
		//logValuesRepository.save(logValues);
		System.out.println("dentro del servicio");
    }

}
