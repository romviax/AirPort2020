package AirPort;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight{
	private String airline;
	private int terminal;
	private String flightId;
	private String arrivalName;
	private String departureName;
	private LocalTime arrivalTime;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private LocalTime departureTime;


	public Flight(String airline, String arrivalName, String departureName,  LocalTime departureTime,LocalTime arrivalTime,
			LocalDate departureDate,LocalDate arrivalDate, 
			int terminal, String flightId) {
		this.airline = airline;
		this.terminal = terminal;
		this.flightId = flightId;
		this.arrivalName = arrivalName;
		this.departureName = departureName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
			
	}
	public Flight(Flight flight) {
		this.terminal = flight.getDepartureTerminal();
		this.flightId = flight.getFlightId();
		this.arrivalName = flight.getArrivalName();
		this.departureName = flight.getDepartureName();
		this.arrivalTime = flight.getArrivalTime();
		this.departureTime = flight.getDepartureTime();
		this.arrivalDate = flight.getArrivalDate();
		this.departureDate = flight.getDepartureDate();
		this.airline = flight.getAirline();
	}

	public String getFlightId() {
		return flightId;
	}

	public String getArrivalName() {
		return arrivalName;
	}

	public String getDepartureName() {
		return departureName;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}
	
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public int getDepartureTerminal() {
		return this.terminal;
	}

	public void setDepartureTerminal(int departureTerminal) {
		this.terminal = departureTerminal;
	}
	
	public String getAirline() {
		return this.airline;
	}
	public boolean equals (Object other) {
		if(!(other instanceof Flight))
			return false;
		Flight temp=(Flight)other;
		return flightId==temp.getFlightId() && airline.equals(temp.getAirline());
	}

	@Override
	public String toString() {
		return "Flight: " +  flightId+ ", Airline:"+this.airline+ ", Departure : " + departureName + ", Arrival: " + arrivalName + " , Departure Time: " +departureDate.getDayOfMonth()+"/"+departureDate.getMonthValue()+"/"+departureDate.getYear()+" at "+ departureTime 
				+ ", Arrival Time: "+arrivalDate.getDayOfMonth()+"/"+arrivalDate.getMonthValue()+"/"+arrivalDate.getYear()+" at "+ arrivalTime + "\n";
	}

}
