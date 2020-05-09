package AirPort;
import java.time.LocalDate;
import java.util.ArrayList;
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

	public void addFlight(Flight flight) {
		if(flight.getDepartureName().equals("Israel"))
			getDeparture().addFlight(flight);
		else
			getArrival().addFlight(flight);
	}
	public ArrayList<Flight> searchArrivalsByDate(Flight[] arrivals,LocalDate lowDate, LocalDate highDate){
		ArrayList<Flight> results=new ArrayList<Flight>();
		for(int i=0;i<arrivals.length;i++)
			if(arrivals[i]!=null)
				if((arrivals[i].getArrivalDate().compareTo(lowDate)>=0) && (arrivals[i].getArrivalDate().compareTo(highDate)<=0))
					results.add(arrivals[i]);
		return results;
	}

	public ArrayList<Flight> searchDeparturesByDate(Flight[] departures,LocalDate lowDate, LocalDate highDate){
		ArrayList<Flight> results=new ArrayList<Flight>();
		for(int i=0;i<departures.length;i++)
			if((departures[i].getDepartureDate().compareTo(lowDate)>=0) && (departures[i].getDepartureDate().compareTo(highDate)<=0))
				results.add(departures[i]);
		return results;
	}

	@Override
	public String toString() {
		return "Airport:\n" + airportName+ "\n----Departures----\n" + myDepartures.toString() + "\n----Arrivals----\n" + myArrivals.toString();
	}

}
