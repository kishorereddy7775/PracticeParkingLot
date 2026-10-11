package com.entites;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ParkingSpot {

	private Map<VehicleType, Queue<Integer>> availableSpots;
	
	public ParkingSpot(int spotsForeachType){
		availableSpots=new HashMap<>();
		availableSpots.put(VehicleType.BIKE, fillSpots(spotsForeachType));
		availableSpots.put(VehicleType.CAR, fillSpots(spotsForeachType));
		availableSpots.put(VehicleType.LARGE_VEHICLE, fillSpots(spotsForeachType));
	}
	
	private Queue<Integer> fillSpots(int spotsForeachType){
		Queue<Integer> spots=new ArrayDeque<Integer>();
		for(int spot=1;spot<=spotsForeachType;spot++) {
			spots.add(spot);
		}
		return spots;
	}
	
	public int getSpot(VehicleType type) {
		if(availableSpots.get(type).size()==0)
			return 0;
		return availableSpots.get(type).poll();
	}
	
	public void releaseSpot(Ticket ticket) {
		availableSpots.get(ticket.vehicle().type()).add(ticket.spot());
	}
	
}
