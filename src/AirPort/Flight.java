package AirPort;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Flight {
	private String airline;
	private int terminal;
	private String flightId;
	private String comingFrom;
	private String goingTo;
	private LocalTime time;
	private LocalDate date;


	public Flight(String airline, String comingFrom, String goingTo, LocalTime time, LocalDate date, int terminal,
			String flightId) {
		this.airline = airline;
		this.terminal = terminal;
		this.flightId = flightId;
		this.comingFrom = comingFrom;
		this.goingTo = goingTo;
		this.time = time;
		this.date = date;

	}
	public Flight(Scanner scan) {
		String line="";
		String[] info;
		for( int i=0;i<7;i++) {
			line+=scan.next();
		}
		
		info=line.split(",");
		 this.airline=info[0];
		 this.comingFrom=info[1];
		 this.goingTo=info[2];
		 this.time=LocalTime.parse(info[3]);
		 this.date=LocalDate.parse(info[4]);
		 this.terminal=Integer.parseInt(info[5]);
		 this.flightId=info[6];
		
		
	}
	public Flight(Flight flight) {
		this.terminal = flight.getDepartureTerminal();
		this.flightId = flight.getFlightId();
		this.comingFrom = flight.getArrivalName();
		this.goingTo = flight.getDepartureName();
		this.time = flight.getTime();
		this.date = flight.getDate();
		this.airline = flight.getAirline();
	}

	public String getFlightId() {
		return flightId;
	}

	public String getArrivalName() {
		return comingFrom;
	}

	public String getDepartureName() {
		return goingTo;
	}

	public LocalTime getTime() {
		return time;
	}

	public LocalDate getDate() {
		return date;
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

	public boolean equals(Object other) {
		if (!(other instanceof Flight))
			return false;
		Flight temp = (Flight) other;
		return flightId == temp.getFlightId() && airline.equals(temp.getAirline());
	}
	
	public void save(PrintWriter pw) {
		pw.print(this.airline+", ");
		pw.print(this.comingFrom +", ");
		pw.print(this.goingTo+", ");
		pw.print(this.time.toString()+", ");
		pw.print(this.date.toString()+", ");
		pw.print(this.terminal+", ");
		pw.print(this.flightId+", ");
		pw.println();

	}

	@Override
	public String toString() {
		return "Flight: " + flightId + ", Airline:" + this.airline + ", Departure : " + goingTo + ", Arrival: "
				+ comingFrom + " , Departure: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/"
				+ date.getYear() + ", Arrival Time: "  + time + "\n";
	}

}
