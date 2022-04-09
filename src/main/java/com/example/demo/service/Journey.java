package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.domain.Station;
import com.example.demo.domain.trips.Trip;

public interface Journey {

	List<Trip> sort(Station from, Station to, Map<Station, Set<Trip>> destniationMap);	
	
	String print(Station to, List<Trip> sortedList);
}
