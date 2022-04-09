package com.example.demo.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Station;
import com.example.demo.domain.trips.BusTrip;
import com.example.demo.domain.trips.FleightTrip;
import com.example.demo.domain.trips.TrainTrip;
import com.example.demo.domain.trips.Trip;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class JourneyImplTest {
	
	@Autowired 
	private Journey journeyService; 
	
	private static Map<Station, Set<Trip>> destniationMap;
	private static Station madrid = new Station("Madrid");
	private static Station barcelona = new Station("Barcelona");
	private static Station gerona = new Station("Gerona AirPort");
	private static Station stockholm = new Station("Stockholm");
	private static Station newYork = new Station("New York JFK");

	
	@BeforeAll
	public static void init() {
		destniationMap = new HashMap<>();

		Trip t1 = new TrainTrip(madrid, barcelona, "78A", "45B");
		Trip t2 = new BusTrip(barcelona, gerona, "airport", null);		
		Trip t3 = new FleightTrip(gerona, stockholm, "SK455", "3A", "45B", "344");	
		Trip t4 = new FleightTrip(stockholm, newYork, "SK22", "7B", "22", null);	
		
		destniationMap.put(madrid, new HashSet<>(Arrays.asList(t1)));
		destniationMap.put(barcelona, new HashSet<>(Arrays.asList(t2)));
		destniationMap.put(gerona, new HashSet<>(Arrays.asList(t3)));
		destniationMap.put(stockholm, new HashSet<>(Arrays.asList(t4)));
		destniationMap.put(newYork, new HashSet<>());
		
	}
	
	@Test
	public void testFindFrom() {
		List<Trip> sortedTrips = journeyService.sort(madrid, newYork, destniationMap);
		assertTrue(sortedTrips.get(0).getDescription().equals("Take TRAIN 78A from Madrid to Barcelona. Sit in seat 45B"));
	}
	
	@Test
	public void testPrint() {
		List<Trip> sortedTrips = journeyService.sort(madrid, newYork, destniationMap);
		String results = journeyService.print(newYork, sortedTrips);
		assertTrue(sortedTrips.size() == 4);
		assertTrue(results.equals("Take TRAIN 78A from Madrid to Barcelona. Sit in seat 45B\r\n"
				+ "Take the airport BUS from Barcelona to Gerona AirPort. No seat assignment\r\n"
				+ "From Gerona AirPort Airport, take FLIGHT SK455 to Stockholm. Gate 45B,Sit in seat 3A Baggage drop at ticket counterBaggage drop at ticket counter 344.\r\n"
				+ "From Stockholm Airport, take FLIGHT SK22 to New York JFK. Gate 22,Sit in seat 7B Baggage drop at ticket counterBaggage will we automatically transferred from your last leg.\r\n"
				+ "You have arrived at your final destination."));
	}

}
