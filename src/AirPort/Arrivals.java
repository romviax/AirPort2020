package AirPort;
import java.util.Arrays;

public class Arrivals {
	private Flight[] myFlights;
	private int flightIndex = 0;

	public Arrivals(int numOfFlights) {
		this.myFlights = new Flight[numOfFlights];
	}

	public void addFlight(Flight flight) {
		if(flightIndex==myFlights.length)
			myFlights=Arrays.copyOf(myFlights, myFlights.length*2);
		this.myFlights[this.flightIndex] = new Flight(flight);
		this.flightIndex++;
	}

	public void removeFlight(Flight flight) {
		int index=-1;
		for(int i=0;i<myFlights.length;i++)
			if(myFlights[i].equals(flight))
				index=i;
		if(index>=0) {
			this.flightIndex--;
			System.arraycopy(this.myFlights, index + 1, this.myFlights, index,
					this.myFlights.length - 1 - index);
		}
	}
	
	public void sort() {
		Arrays.sort(myFlights, new CompareFlightArrivals());
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(flightIndex==0)
			return "There are no arrivals";
		for (int i=0;i<flightIndex;i++) {
			sb.append(myFlights[i].toString());
		}
		return sb.toString();
	}

}
