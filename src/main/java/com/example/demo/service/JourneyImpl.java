package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Station;
import com.example.demo.domain.trips.Trip;

@Service
public class JourneyImpl implements Journey {

	@Override
	public List<Trip> sort(Station from, Station to, Map<Station, Set<Trip>> destMap) {
		
		List<Trip> sortedList = new ArrayList<>();
		
		if(Objects.isNull(from)){
			throw new IllegalArgumentException("Missing From");
		}
		if(Objects.isNull(to)){
			throw new IllegalArgumentException("Missing To");
		}
		
		// first trip	
		Optional<Trip> currTrip = findTrip(from, destMap);
		
		while(currTrip.isPresent()) {
			sortedList.add(currTrip.get());	
			currTrip = findTrip(currTrip.get().getTo(), destMap);
		}

		return sortedList;
				
	}
	
	@Override
	public String print(Station to, List<Trip> sortedList) {

		StringBuilder results = new StringBuilder();

		if (!sortedList.isEmpty()) {

			if (sortedList.get(sortedList.size() - 1).getTo().equals(to)) {
				results.append(sortedList.stream().map(e -> e.getDescription()).collect(Collectors.joining("\r\n")));
				results.append("\r\nYou have arrived at your final destination.");
			} else {
				results.append("No final destination found.");
			}
		}

		return results.toString();
	}

	private Optional<Trip> findTrip(Station from, Map<Station, Set<Trip>> destMap) {
		if(destMap.containsKey(from)){
			return destMap.get(from).stream().findFirst();
		}else {
			//throw new IllegalArgumentException("Broken Destnation: " + from);
			return Optional.empty();
		}
	}



}
