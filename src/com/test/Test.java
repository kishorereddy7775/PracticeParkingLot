package com.test;

import com.entites.Ticket;
import com.entites.Vehicle;
import com.entites.VehicleType;
import com.service.ParkingLot;

public class Test {

	public static void main(String[] args) throws Exception {
		ParkingLot parkingLot=new ParkingLot();
		
		Vehicle vehicle=new Vehicle(1,VehicleType.BIKE);
		//park vehicle
		Ticket ticket = parkingLot.enter(vehicle);
		for(int i=1;i<5;i++) {
			//parking 4 more bikes
			parkingLot.enter(vehicle);
		}
		//exit a bike
		System.out.println(parkingLot.exit(ticket));
		//park a bike(should not throw error)
		parkingLot.enter(vehicle);
	}
}
