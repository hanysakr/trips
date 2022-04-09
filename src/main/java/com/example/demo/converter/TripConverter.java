package com.example.demo.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;
import com.example.demo.domain.trips.BusTrip;
import com.example.demo.domain.trips.FleightTrip;
import com.example.demo.domain.trips.TrainTrip;
import com.example.demo.domain.trips.Trip;
import com.example.demo.dto.TripDTO;

public class TripConverter {
	
	public static Map<Station, Set<Trip>> convert(List<TripDTO> list) {
		Map<Station, Set<Trip>> destniationMap = new HashMap<>();
		list.forEach(trip->{
			if(trip.getTransportType().equals(TransportTypeEnum.BUS)){				
				destniationMap.put(trip.getFrom(), new HashSet<>(Arrays.asList(
						new BusTrip(trip.getFrom(),trip.getTo(), trip.getName() ,trip.getSeat()))));
			}else if(trip.getTransportType().equals(TransportTypeEnum.FLIGHT)){				
				destniationMap.put(trip.getFrom(), new HashSet<>(Arrays.asList(
						new FleightTrip(trip.getFrom(),trip.getTo(), trip.getName() ,trip.getSeat(), trip.getGate(), trip.getBaggageCounter()))));
			}else if(trip.getTransportType().equals(TransportTypeEnum.TRAIN)){				
				destniationMap.put(trip.getFrom(), new HashSet<>(Arrays.asList(
						new TrainTrip(trip.getFrom(),trip.getTo(), trip.getName() ,trip.getSeat()))));
			}
						
		});		
		return destniationMap;
	}

}
