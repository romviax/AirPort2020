package AirPort;
import java.util.Arrays;

public class Airport {
	private Departures myDepartures;
	private Arrivals myArrivals;
	private String airportName;
	
	
	public Airport(String name ) {
		this.airportName = name;
		this.myDepartures = new Departures(10);
		this.myArrivals = new Arrivals(10);
	}
	public Departures getDeparture() {
		return this.myDepartures;
	}
	public Arrivals getArrival() {
		return this.myArrivals;
	}

	@Override
	public String toString() {
		return "Airport:\n" + airportName+ "\n----Departures----\n" + myDepartures.toString() + "\n----Arrivals----\n" + myArrivals.toString();
	}
	
}
