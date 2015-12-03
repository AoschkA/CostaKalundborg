package test;

import java.util.ArrayList;

import entity.reservation.BookingCalendar;

public class BookingCalenderTest {
	private static BookingCalendar bc = new BookingCalendar();

	public static void main(String[] args){
		String arrivalDate ="2015-12-12";
		String departureDate ="2015-12-24";
		int type = 1;

		ArrayList<String> test = null;;
		ArrayList<String> test1 = null;;
		for(int i=0;i<1; i++){
			test= bc.getOccupiedDays(arrivalDate, departureDate, type );
			test1=bc.setReservation(arrivalDate, departureDate, type, 1);
		}
		if(!test.isEmpty()){
			for(int i=0; i<test.size();i++){
				System.out.println(test.get(i));
			}
		}
		for(int i=0; i<test.size();i++){
			System.out.println(test1.get(i));
		}
	}
}
