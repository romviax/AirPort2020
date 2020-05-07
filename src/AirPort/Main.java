package AirPort;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import javafx.util.converter.LocalDateStringConverter;

import java.time.Month;
public class Main {
	public static void addFlight(Airport airport) {
		Scanner scan=new Scanner(System.in);
		String name, arrivalName,departureName, flightId;
		LocalTime departureTime,arrivalTime;
		LocalDate departureDate,arrivalDate;
		System.out.println("Please enter the airline's name: ");
		name=scan.next();
		System.out.println("Enter the filght's ID: ");
		flightId=scan.next();
		System.out.println("This flight departs from: ");
		departureName=scan.next();
		System.out.println("This flight arrives to: ");
		arrivalName=scan.next();
		
		System.out.println("Eneter the date of departure: (DD/MM/YYYY)");
		String date= scan.next();
		String[] splitDate=date.split("/");
		departureDate=LocalDate.of(Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]),Integer.parseInt(splitDate[0]));
		
		System.out.println("Eneter the date of arrival: (DD/MM/YYYY)");
		date= scan.next();
		splitDate=date.split("/");
		departureDate=LocalDate.of(Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]),Integer.parseInt(splitDate[0]));
		
		System.out.println("Enter the time of departure: (MM:HH)");
		String time= scan.next();
		String[] splitTime=time.split(":");
		departureTime=LocalTime.of(Integer.parseInt(splitTime[1]), Integer.parseInt(splitTime[0]));
		
	}
 
	
	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);	
		Airport airport = new Airport("Ben Gurion");
		LocalDate arrivalTime = LocalDate.of(2020, 5, 20);
		LocalDate departureDate1 = LocalDate.of(2020, 5, 19);
		LocalTime departureTime1= LocalTime.of(19, 30);
		LocalTime departureTime2= LocalTime.of(19, 20);
		LocalTime arrivalTime1= LocalTime.of(20, 30);
		LocalTime arrivalTime2= LocalTime.of(20, 20);
		Flight f1 = new Flight("El-al", "New York", "Israel", arrivalTime1, departureTime1,departureDate1,arrivalTime,3, "LY365");
		Flight f2 = new Flight("JesterAirLines", "Alaska", "Israel", arrivalTime1, departureTime1,LocalDate.of(2020, 6, 19),LocalDate.of(2020, 3, 20),3, "IL231");
		Flight f3 = new Flight("Transvania", "Jordan", "Israel", arrivalTime2, departureTime2,LocalDate.of(2020, 4, 14),LocalDate.of(2020,3, 20),3, "NY786");

		airport.getDeparture().addFlight(f1);
		airport.getDeparture().addFlight(f2);
		airport.getDeparture().addFlight(f3);
		airport.getDeparture().sort();
		System.out.println(airport);
		
	}

}
