/**
 * 
 */
package catering;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Maruti on Apr 5, 2017 at 11:38:09 PM
 *
 */
public class MyCatering {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		Event event = getEventInfo();
		event.printEvent();
	}
	
	public static Event getEventInfo() throws ParseException{
		String eventName = getEventName();
		int guestNum = getGuest();
		String eventDate = getEventDate();
		Event event = new Event(eventName, eventDate, guestNum);
		return event;
	}

	/**
	 * @return
	 */
	private static String getEventDate() {
		System.out.println("When is the date of your event? (mm/dd/yyyy)");
		String inDate = in.nextLine();
		DateFormat d = new SimpleDateFormat("mm/dd/yyyy");
		Date eventDate = null;
		try{
			eventDate = d.parse(inDate);
		}
		catch(ParseException e){
			System.out.println("Please enter the date format as specified above.");
		}
		
		String finalEventDate = d.format(eventDate);
		return finalEventDate;
	}

	/**
	 * @return
	 */
	private static int getGuest() {
		System.out.println("How many guests are you expecting?");
		while(!in.hasNextInt()){
			System.out.println("Invalid value, please enter the number of guests as a whole number");
			in.nextLine();
		}
		int guestNum = in.nextInt();
		in.nextLine();
		return guestNum;
	}

	/**
	 * @return
	 */
	private static String getEventName() {
		int select = 0;
		boolean first = true;
		do{
			if(first == true)
				first = false;
			else
				System.out.println("Invalid Selection, please try again");
			
			System.out.println("What is the type or the name of event you are hosting: "
					+ "\n1. Wedding"
					+ "\n2. Birthday"
					+ "\n3. Shower"
					+ "\n4. Other"
					+ "\n Please select your option:");
			select = in.nextInt();
			in.nextLine();
		}while(select != 1 && select != 2 && select != 3 && select != 4);
		switch(select){
		case 1: return "Wedding";
		case 2: return "Birthday";
		case 3: return "Shower";
		case 4: 
			System.out.println("Please enter type of event");
			String eventName = in.nextLine();
			return eventName;
		}
		return "No type selected";
	}
	
	
	

}
