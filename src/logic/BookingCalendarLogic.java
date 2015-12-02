package logic;

import java.util.ArrayList;
import entity.BookingCalendar;

public class BookingCalendarLogic {
	
	protected enum Type {Caravan, LargeCaravan, Tent, LuxuryCottagePatio, LuxuryCottage, LargeCottage, MediumCottage, SmallCottage};

	BookingCalendar bc = new BookingCalendar();
	
	public ArrayList<String> changeReservation(){
		ArrayList<String> result = new ArrayList<String>();;
		return result;
	}
	
	public ArrayList<String> checkPeriod(String arrivalDate, String departureDate, int type){
		return bc.getOccupiedDays(arrivalDate, departureDate, type);
	}
	
	public void reservePeriod(String arrivalDate, String departureDate, int type){
		bc.setReservation(arrivalDate, departureDate, type, 1);
	}
	
	public void deletePeriod(String startDate, String endDate, int type){
		bc.setReservation(startDate, endDate, type, -1);
	}
}
