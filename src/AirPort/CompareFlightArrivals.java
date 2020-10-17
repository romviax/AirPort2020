package AirPort;

import java.util.Comparator;

public class CompareFlightArrivals implements Comparator<Flight> {

	public int compare(Flight flight1, Flight flight2) {
		if(flight1==null||flight2==null)
			return 1;
		if(flight1.getArrivalDate().compareTo(flight2.getArrivalDate())==0)
			return flight1.getArrivalTime().compareTo(flight2.getArrivalTime());
		return flight1.getArrivalDate().compareTo(flight2.getArrivalDate());
	}
}