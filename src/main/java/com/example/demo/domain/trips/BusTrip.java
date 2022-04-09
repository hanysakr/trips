package com.example.demo.domain.trips;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;

public class BusTrip extends Trip {

	public BusTrip(Station from, Station to, String name, String seat) {
		super(from, to, name , seat, TransportTypeEnum.BUS);
	}

	@Override
	public String getDescription() {
		//Take the *airport* bus from *Barcelona* to *Gerona Airport*. No seat assignment
		return new StringBuilder("Take the ")
				.append(name).append(SPACE)
				.append(TransportTypeEnum.BUS).append(SPACE)				
				.append("from").append(SPACE)
				.append(from.getName()).append(SPACE)
				.append("to").append(SPACE)
				.append(to.getName()).append(".").append(SPACE)
				.append(getSeat())
				.toString();
	}

}
