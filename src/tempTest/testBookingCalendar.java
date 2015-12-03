package tempTest;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.reservation.BookingCalendar;

public class testBookingCalendar {

	@Test
	public void test() {
		BookingCalendar bc = new BookingCalendar();
		int counter = 0;
		for(int i = 0;i < 12;i++){
			for(int j = 0;j < 20;j++){
				counter++;
				bc.setBookingDay(i, j, 2, counter);
			}
		}
		for(int i = 0;i < 12;i++){
			for(int j = 0;j < 25;j++){
				System.out.println(bc.getBookingDay(i, j, 2));
			}
		}
		bc.setBookingDay(11, 30, 1, 500);
		assertEquals(500, bc.getBookingDay(11, 30, 1));
		assertEquals(1, bc.getBookingDay(11, 29, 1));
		bc.setBookingDay(11, 23, 1, 110);
		bc.setBookingDay(11, 28, 1, 200);
		System.out.println(bc.getOccupiedDays("2015-12-20", "2015-12-31", 1).size());
	}

}
