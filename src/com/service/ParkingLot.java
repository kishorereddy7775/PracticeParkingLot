package com.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.entites.ChargeCalculator;
import com.entites.ParkingSpot;
import com.entites.SimpleChargeCalculator;
import com.entites.Ticket;
import com.entites.Vehicle;
import com.exception.ParkingLotException;

public class ParkingLot {
	//DB to store Assigned tickets
	private Map<Integer,Ticket> ticketsAssigned;
	private ParkingSpot parkingSpots;
	private int ticketCounter;
	private ChargeCalculator chargeCalculator;
	
	public ParkingLot() {
		ticketsAssigned=new HashMap<Integer, Ticket>();
		//for simplicity I'm hot-coding the spots, but in production I will get this dynamically for parkingLot constructor
		parkingSpots=new ParkingSpot(5);
		ticketCounter=1;
		//Since I was asked to use simple calculations I'm using the below, orelse I would have passed this in constructor or exit method for dynamic price calculations
		chargeCalculator=new SimpleChargeCalculator();
	}
	
	public synchronized Ticket enter(Vehicle vehicle) throws Exception{
		int spot=parkingSpots.getSpot(vehicle.type());
		if(spot==0)
			throw new ParkingLotException("Parking is not Available");
		Ticket ticket=new Ticket(ticketCounter++,LocalDateTime.now(),spot,vehicle);
		ticketsAssigned.put(ticketCounter-1, ticket);
		return ticket;
	}
	public synchronized double exit(Ticket ticket) throws Exception {
		if(ticketsAssigned.get(ticket.id())==null)
			throw new ParkingLotException("Invalid Ticket");
		double charge=chargeCalculator.calculateCharge(ticket);
		parkingSpots.releaseSpot(ticket);
		return charge;
	}
}
