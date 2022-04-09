package com.example.demo.domain.trips;

import java.util.Objects;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;

public class FleightTrip extends Trip {
	
	private String gate;
	private String baggageCounter;

	public FleightTrip(Station from, Station to, String name, String seat, String gate, String baggageCounter) {
		super(from, to, name, seat, TransportTypeEnum.FLIGHT);
		this.gate = gate;
		this.baggageCounter = baggageCounter;
	}

	@Override
	public String getDescription() {
		// From *Gerona* Airport, take flight *SK455* to *Stockholm*. Gate *45B*, seat *3A*. Baggage drop at ticket counter *344*.
		//From Stockholm, take flight SK22 to New York JFK. Gate 22, seat 7B. Baggage will we automatically transferred from your last leg.


		return new StringBuilder("From").append(SPACE)
				.append(from.getName()).append(SPACE)
				.append("Airport,").append(SPACE)
				.append("take").append(SPACE)
				.append(TransportTypeEnum.FLIGHT).append(SPACE)	
				.append(name).append(SPACE)							
				.append("to").append(SPACE)
				.append(to.getName()).append(".").append(SPACE)
				.append("Gate").append(SPACE)
				.append(gate)
				.append(",")								
				.append(getSeat()).append(SPACE)
				.append("Baggage drop at ticket counter")
				.append(getBaggageCounter()).append(".")
				.toString();
	}

	public String getGate() {
		return gate;
	}

	public String getBaggageCounter() {
		return Objects.nonNull(baggageCounter)? 
				"Baggage drop at ticket counter " + baggageCounter
				:"Baggage will we automatically transferred from your last leg";
	}
	

}
