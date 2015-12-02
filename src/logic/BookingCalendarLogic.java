package logic;

import java.util.ArrayList;
import entity.BookingCalendar;

public class BookingCalendarLogic {
	
	protected enum Type {Caravan, LargeCaravan, Tent, LuxuryCottagePatio, LuxuryCottage, LargeCottage, MediumCottage, SmallCottage};

	BookingCalendar bc = new BookingCalendar();
	
	public ArrayList<String> checkPeriod(String arrivalDate, String departureDate, int type){
		return new ArrayList();
	}
	
	public void reservePeriod(String arrivalDate, String departureDate, int type){
		
	}
	
	public void deletePeriod(String startDate, String endDate, int type){
		
	}

}
