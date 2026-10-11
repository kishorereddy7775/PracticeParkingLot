package com.entites;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class SimpleChargeCalculator implements ChargeCalculator {

	private Map<VehicleType, Double> chargesPerHour;
	public SimpleChargeCalculator() {
		chargesPerHour=new HashMap<VehicleType, Double>();
		chargesPerHour.put(VehicleType.BIKE, 30.0);
		chargesPerHour.put(VehicleType.CAR, 50.0);
		chargesPerHour.put(VehicleType.LARGE_VEHICLE, 80.0);
	}
	@Override
	public double calculateCharge(Ticket ticket) {
		Vehicle vehicle=ticket.vehicle();
		double chargePerHour=chargesPerHour.get(vehicle.type());
		long minutes=ChronoUnit.MINUTES.between(ticket.entryTime(), LocalDateTime.now());
		long hours = minutes/60 + (minutes%60==0 ? 0:1);
		return hours*chargePerHour;
	}
	
	
}
