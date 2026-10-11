Design Parking lot system

Requirements:
1. System should assign a spot to vehicle on entry and assign a ticket
2. Vehicle should give the ticket on exit and we will calculate the charge and release the spot.
3. pricing will be simple for now may be hourly basis(roundup to next hour) for type of vehicle.
4. If spot is not available we need to reject the entry
5. If ticket is invalid then we will throw error.
6. We will 3 types of vehicle (bike, car, largeVehicle)
6. Many entries and exits and complex price calculations are out of scope.

Entities and relationship:
vehicleType
Vehicle
ticket
Parkingspot
ParkingLot

Pricing(interface) --> simplePrice
vehicle->vehicleType
ticket->vehicle,parkingspot
parkingLot->ticket,parkingspot

class Design:
ParkingLot
	-AssignedTickets
	-parkingspot

	+enter(vehicle)->void/error
	+exit(ticket)->void/error

parkingSpot
	-AvailableSpots

	+getSpot(vehicleType)->int/0(no spot)
	-releasespot(Ticket)->void

ticket
	-vehicle
	-entryTime
	-spot
	
	+getSpot()->int
	+getEntryTime()->time
	+getVehicleType()->vehicleType

vehicle
	id
	vehicleType

	getType()->vehicleType

pricing
	
	getPrice(vehicleType);

simplePrice
	getPrice(vehicleType);