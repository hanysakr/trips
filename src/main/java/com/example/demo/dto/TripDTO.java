package com.example.demo.dto;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;

public class TripDTO {

	public Station from;
	public Station to; 
	public TransportTypeEnum transportType;
	public String seat;
	public String name;
	private String gate;
	private String baggageCounter;
	
	public TripDTO() {}
	
	
	public Station getFrom() {
		return from;
	}
	public void setFrom(Station from) {
		this.from = from;
	}
	public Station getTo() {
		return to;
	}
	public void setTo(Station to) {
		this.to = to;
	}
	public TransportTypeEnum getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportTypeEnum transportType) {
		this.transportType = transportType;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getBaggageCounter() {
		return baggageCounter;
	}
	public void setBaggageCounter(String baggageCounter) {
		this.baggageCounter = baggageCounter;
	}
	
	
}
