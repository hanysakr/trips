package com.example.demo.domain.trips;

import com.example.demo.domain.Station;
import com.example.demo.domain.TransportTypeEnum;

public class TrainTrip extends Trip {

	public TrainTrip(Station from, Station to, String name, String seat) {
		super(from, to, name, seat, TransportTypeEnum.TRAIN);
	}

	@Override
	public String getDescription() {
		// Take train 78A from Madrid to Barcelona. Sit in seat 45B
		return new StringBuilder("Take").append(SPACE)
				.append(TransportTypeEnum.TRAIN).append(SPACE)	
				.append(name).append(SPACE)							
				.append("from").append(SPACE)
				.append(from.getName()).append(SPACE)
				.append("to").append(SPACE)
				.append(to.getName()).append(".").append(SPACE)
				.append(getSeat())
				.toString();
	}

}
