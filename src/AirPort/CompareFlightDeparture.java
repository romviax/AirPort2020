package AirPort;

import java.util.Comparator;

public class CompareFlightDeparture implements Comparator<Flight> {
	public int compare(Flight flight1, Flight flight2) {
		if(flight1==null||flight2==null)
			return 1;
		if(flight1.getDepartureDate().compareTo(flight2.getDepartureDate())==0) 
			return(flight1.getDepartureTime().compareTo(flight2.getDepartureTime()));
		return (flight1.getDepartureDate().compareTo(flight2.getDepartureDate()));
		
	}

}
