/**
 * 
 */
package catering;

/**
 * @author Maruti on Apr 5, 2017 at 11:37:55 PM
 *
 */
public class Event {
	public static int nextEventNum = 100;
	private String eventNum;
	private String eventName;
	private int guestNum;
	private final double pricePerGuest = 40.00;
	private String eventDate;
	
	public Event(String type){
		eventName = type;
		guestNum = 0;
		eventDate = null;
		setEventNum(eventName);
	}
	
	public Event(String type, String eventDate){
		eventName = type;
		guestNum = 0;
		this.eventDate = eventDate;
		setEventNum(eventName);
	}
	
	public Event(String type, String eventDate, int numGuests){
		eventName = type;
		guestNum = numGuests;
		this.eventDate = eventDate;
		setEventNum(eventName);
	}
	
	public void incrementEventNum(){
		nextEventNum++;
	}
	
	/**
	 * Event Number
	 */
	
	public void setEventNum(String eventName){
		eventNum = ""+eventName.charAt(0) + nextEventNum;
		incrementEventNum();
	}
	
	public String getEventNum(){
		return eventNum;
	}
	
	/**
	 * Event GuestCount
	 */
	
	public void setGuest(int val){
		if(val<20 || val>100)
			System.out.println("Sorry!!, Our Accomodation is limited to the range of guests between 20-100");
		else
			guestNum = val;
	}
	
	public int getGuest(){
		return guestNum;
	}
	
	/**
	 * Event Name
	 */
	
	public void setEventName (String val){
		eventName = val;
	}
	
	public String getEventName(){
		return eventName;
	}
	
	/**
	 * Event Date
	 */
	
	public void setEventDate(String date){
		eventDate = date;
	}
	
	
	
	public String getEventDate(){
		return eventDate;
	}
	
	/**
	 * Total Function
	 */
	
	public double getTotal(){
		return guestNum * pricePerGuest;
	}
	
	
	public void printEvent(){
		System.out.printf("\nYour Event is for a %s \n"
				+ "Event Number: %s \n"
				+ "Scheduled Event Date: %s \n"
				+ "Expected Guests Count: %d \n"
				+ "Total Cost for the Event: %6.2f", eventName, eventNum, eventDate, guestNum, getTotal());
		System.out.println();
	}
}

