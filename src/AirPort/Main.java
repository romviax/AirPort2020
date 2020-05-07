package AirPort;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.Month;
public class Main {
 
	
	public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);	
		Airport ap = new Airport("Ben Gurion");
		LocalDate arrivalTime = LocalDate.of(2020, 5, 20);
		LocalDate departureDate1 = LocalDate.of(2020, 5, 19);
		LocalTime departureTime1= LocalTime.of(19, 30);
		LocalTime departureTime2= LocalTime.of(19, 20);
		LocalTime arrivalTime1= LocalTime.of(20, 30);
		LocalTime arrivalTime2= LocalTime.of(20, 20);
		Flight f1 = new Flight("El-al", "New York", "Israel", arrivalTime1, departureTime1,departureDate1,arrivalTime,3, "LY365");
		Flight f2 = new Flight("JesterAirLines", "Alaska", "Israel", arrivalTime1, departureTime1,LocalDate.of(2020, 6, 19),LocalDate.of(2020, 3, 20),3, "IL231");
		Flight f3 = new Flight("Transvania", "Jordan", "Israel", arrivalTime2, departureTime2,LocalDate.of(2020, 4, 14),LocalDate.of(2020,3, 20),3, "NY786");

		ap.getDeparture().addFlight(f1);
		ap.getDeparture().addFlight(f2);
		ap.getDeparture().addFlight(f3);
		ap.getDeparture().sort();
		System.out.println(ap);
		
	}

}
