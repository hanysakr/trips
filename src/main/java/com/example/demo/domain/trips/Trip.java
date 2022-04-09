package com.example.demo.domain.trips;

import java.util.Objects;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;

public abstract class Trip {

	public static String SPACE=" ";
	
	public Station from;
	public Station to; 
	public TransportTypeEnum transportType;
	public String seat;
	public String name;
	
	public Trip() {		
	}
	
	// TODO convert the constructor to builder pattern
	public Trip(Station from, Station to, String name, String seat, TransportTypeEnum transportType) {
		this.from = from;
		this.to = to;
		this.transportType = transportType;
		this.seat = seat;
		this.name = name;
	}

	
	public Station getFrom() {
		return from;
	}
	public Station getTo() {
		return to;
	}
	public TransportTypeEnum getTransportType() {
		return transportType;
	}

	public String getName() {
		return name;
	}

	public String getSeat() {
		return Objects.isNull(seat)? "No seat assignment" : "Sit in seat "+ seat;
	}

	public abstract String getDescription();
	
}
