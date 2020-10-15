package tests;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import AirPort.Airport;
import AirPort.Flight;
import junit.framework.TestCase;

public class TestAP extends TestCase {
	
	Airport ap = new Airport("Ben-Gurion");
	LocalDate date1 = LocalDate.of(2020, 5, 20);
	LocalDate date2 = LocalDate.of(2020, 4, 20);
	LocalDate date3 = LocalDate.of(2020, 3, 20);
	LocalDate date4 = LocalDate.of(2020, 4, 17);
	LocalDate date5 = LocalDate.of(2020, 4, 25);
	LocalTime time1 = LocalTime.of(14, 02);
	LocalTime time2 = LocalTime.of(19, 02);
	LocalTime time3 = LocalTime.of(20, 30);
	LocalTime time4 = LocalTime.of(20, 20);
	Flight f1 = new Flight("El-al", "New York", "Israel", time3, date1, 3, "LY365");
	Flight f2 = new Flight("JesterAirLines", "Alaska", "Israel", time3, date3, 3, "IL231");
	Flight f3 = new Flight("Transvania", "Jordan", "Israel", time4, date4, 3, "NY786");
	Flight f4 = new Flight("StarAir", "Israel", "New York", time1, date2, 3, "SA154");
	Flight f5 = new Flight("EL AL", "Israel", "Germany", time2, date5, 3, "FA194");

	@Test
	public void addInFlightTest() {
		ap.addFlight(f4);
		assertTrue(ap.getArrival().getFlightById("SA154").toString().equals(
				"Flight: SA154, Airline:StarAir, Departure : New York, Arrival: Israel , Departure Time: 18/4/2020 at 20:20, Arrival Time: 20/4/2020 at 14:02\n"));
	}
	
	@Test
	public void addOutFlightTest() {
		ap.addFlight(f2);
		assertTrue(ap.getDeparture().getFlightById("IL231").toString().equals(
				"Flight: IL231, Airline:JesterAirLines, Departure : Israel, Arrival: Alaska , Departure Time: 19/3/2020 at 20:30, Arrival Time: 20/3/2020 at 19:30\n"));
	}

	@Test
	public void scearchArrivalsByDateTest() {
		ap.addFlight(f1);
		ap.addFlight(f2);
		ap.addFlight(f3);
	}
}
