package com.exercise.developer.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercise.developer.demo.logvalues.LogValues;

public interface LogValuesRepository extends CrudRepository<LogValues, Integer> {}  
