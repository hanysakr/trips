package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.TripConverter;
import com.example.demo.domain.Station;
import com.example.demo.domain.trips.Trip;
import com.example.demo.dto.TripsDTO;
import com.example.demo.service.Journey;

@RestController
@RequestMapping("/api")
public class SortController {
	
	@Autowired
	private Journey journeyService;
	
	@PostMapping("/sort")
	public String sort(@RequestBody TripsDTO dto) {
		
		Map<Station, Set<Trip>> destniationMap = TripConverter.convert(dto.getDestniationMap());
		
		List<Trip> trips = journeyService.sort(dto.getFrom(), dto.getTo(), destniationMap);
		return journeyService.print(dto.getTo(), trips);
	}
	
	
}