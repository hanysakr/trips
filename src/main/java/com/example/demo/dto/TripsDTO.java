package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Station;

public class TripsDTO {

	private List<TripDTO> destniationMap;
	private Station from;
	private Station to;
	
	public List<TripDTO> getDestniationMap() {
		return destniationMap;
	}
	public void setDestniationMap(List<TripDTO> destniationMap) {
		this.destniationMap = destniationMap;
	}
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
	
	
	
	
	
}
