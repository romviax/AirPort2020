package AirPort;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

import com.sun.glass.ui.Pixels.Format;

import javafx.util.converter.LocalDateStringConverter;

import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Main {

	public static boolean isValidFormat(String format, String value, Locale locale) {
		LocalDateTime ldt = null;
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

		try {
			ldt = LocalDateTime.parse(value, fomatter);
			String result = ldt.format(fomatter);
			return result.equals(value);
		} catch (DateTimeParseException e) {
			try {
				LocalDate ld = LocalDate.parse(value, fomatter);
				String result = ld.format(fomatter);
				return result.equals(value);
			} catch (DateTimeParseException exp) {
				try {
					LocalTime lt = LocalTime.parse(value);
					return true;
				}catch (Exception error) {
					return false;
				}
			}
		}
	}

	public static boolean isValidFlightId(String id) {
		if(id.length()<5 || id.length()>5)
			return false;
		if(id.charAt(0)< 'A' ||id.charAt(0) > 'Z' )
			return false;
		if(id.charAt(1)< 'A' ||id.charAt(1) > 'Z' )
			return false;
		String idNums=id.substring(2);
		try {
			int nums=Integer.parseInt(idNums);
		} catch (Exception error) {
			return false;
		}
		return true;
	}

	public static void addFlight(Airport airport) {
		Scanner scan=new Scanner(System.in);
		String name="", arrivalName="",departureName="", flightId="";
		LocalTime departureTime=null,arrivalTime=null;
		LocalDate departureDate=null,arrivalDate=null;
		int terminal=0;

		System.out.println("Please enter the airline's name: ");
		name=scan.next();
		// Flight ID
		boolean validId=false;
		while(validId==false) {
			System.out.println("Enter the filght's ID: (ex: LY978)");
			flightId=scan.next();
			validId=isValidFlightId(flightId);
			if(validId==false)
				System.out.println("Wrong ID format. must have two uppercase letters followed by 3 digits");
		}

		//Flight's terminal
		boolean validTerminal=false;
		while(validTerminal==false) {
			System.out.println("What terminal is this flight on? ");
			terminal=scan.nextInt();
			if(terminal<=0)
				System.out.println("has to be bigger than 0.");
			else
				validTerminal=true;
		}

		// Check that one of the destinations is Israel.
		boolean validDest=false;
		while(validDest==false) {
			//Departure name
			System.out.println("This flight departs from: ");
			departureName=scan.next();
			scan.nextLine();

			//Arrival name compared to the Departure name
			boolean validArrive=false;
			while(validArrive==false) {
				System.out.println("This flight arrives to: ");
				arrivalName=scan.next();
				if(arrivalName.equals(departureName))
					System.out.println("Cannot arrive to a country you depart from. Try again");
				else
					validArrive=true;
			}
			if(!arrivalName.equals("Israel") && !departureName.equals("Israel"))
				System.out.println("one of the destinations has to be Israel.");
			else
				validDest=true;
		}
		scan.nextLine();

		// Departure date & Arrival date. compared and check.
		System.out.println("NOTE:The Arrival cannot be before the Departure");
		boolean compareDepartArriv=false;
		while(compareDepartArriv==false) {
			String date="";
			boolean validFormat=false;
			while(validFormat==false) {
				System.out.println("Eneter the date of departure: (DD/MM/YYYY)");
				date= scan.next();
				validFormat=isValidFormat("dd/MM/yyyy", date, Locale.ENGLISH);
				if(validFormat==false)
					System.out.println("Wrong date. Please try again.");
			}
			String[] splitDate=date.split("/");
			departureDate=LocalDate.of(Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]),Integer.parseInt(splitDate[0]));
			scan.nextLine();

			validFormat=false;
			while(validFormat==false) {
				System.out.println("Eneter the date of arrival: (DD/MM/YYYY)");
				date= scan.next();
				validFormat=isValidFormat("dd/MM/yyyy", date, Locale.ENGLISH);
				if(validFormat==false)
					System.out.println("Wrong date. Please try again.");
			}
			splitDate=date.split("/");
			arrivalDate=LocalDate.of(Integer.parseInt(splitDate[2]),Integer.parseInt(splitDate[1]),Integer.parseInt(splitDate[0]));

			String time="";
			validFormat=false;
			while(validFormat==false) {
				System.out.println("Enter the time of departure: (HH:MM)");
				time= scan.next();
				validFormat=isValidFormat("hh:mm",time, Locale.ENGLISH);
				if(validFormat==false)
					System.out.println("Wrong time. Please try again.");
			}
			String[] splitTime=time.split(":");
			departureTime=LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1]));

			validFormat=false;
			while(validFormat==false) {
				System.out.println("Enter the time of arrival: (HH:MM)");
				time= scan.next();
				validFormat=isValidFormat("hh:mm",time, Locale.ENGLISH);
				if(validFormat==false)
					System.out.println("Wrong time. Please try again.");
			}
			splitTime=time.split(":");
			arrivalTime=LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1]));

			if(departureDate.equals(arrivalDate)==true) {
				if(departureTime.compareTo(arrivalTime)<0)
					compareDepartArriv=true;
			}
			else if(departureDate.compareTo(arrivalDate)<0)
				compareDepartArriv=true;
			else 
				System.out.println("Wrong timing. NOTE:The Arrival cannot be before the Departure");
		}

		Flight newFlight=new Flight(name, arrivalName, departureName, departureTime, arrivalTime, departureDate, arrivalDate, terminal, flightId);
		if(departureName.equals("Israel"))
			airport.getDeparture().addFlight(newFlight);
		else
			airport.getArrival().addFlight(newFlight);
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
		addFlight(airport);

	}

}
