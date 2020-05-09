package AirPort;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import junit.framework.TestCase;

public class AirportTests extends TestCase {
	
	Airport airport = new Airport("Ben Gurion");
	LocalDate arrivalDate = LocalDate.of(2020, 5, 20);
	LocalDate departureDate1 = LocalDate.of(2020, 5, 19);
	LocalTime departureTime1= LocalTime.of(19, 30);
	LocalTime departureTime2= LocalTime.of(19, 20);
	LocalTime arrivalTime1= LocalTime.of(20, 30);
	LocalTime arrivalTime2= LocalTime.of(20, 20);
	Flight f1 = new Flight("El-al", "New York", "Israel", arrivalTime1, departureTime1,departureDate1,arrivalDate,3, "LY365");
	Flight f2 = new Flight("JesterAirLines", "Alaska", "Israel", arrivalTime1, departureTime1,LocalDate.of(2020, 3, 19),LocalDate.of(2020, 3, 20),3, "IL231");
	Flight f3 = new Flight("Transvania", "Jordan", "Israel", arrivalTime2, departureTime2,LocalDate.of(2020, 4, 14),LocalDate.of(2020,4, 17),3, "NY786");
	Flight f4 = new Flight("StarAir", "Israel", "New York", LocalTime.of(20, 20), LocalTime.of(14, 02),LocalDate.of(2020, 4, 18),LocalDate.of(2020,4, 20),3, "SA154");
	Flight f5 = new Flight("EL AL", "Israel", "Germany", LocalTime.of(8, 20), LocalTime.of(19, 02),LocalDate.of(2020, 4, 25),LocalDate.of(2020,4, 25),3, "FA194");


	
}
