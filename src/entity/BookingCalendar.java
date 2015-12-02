package entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingCalendar {
	//private int january, february, march, april, may, june, july, august, september, october, november, december;
	private static Calendar calendar = new GregorianCalendar();
	private static ArrayList<Integer> booking = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> day = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<ArrayList<ArrayList<Integer>>> month = new ArrayList<ArrayList<ArrayList<Integer>>>();
	private static ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> capacity = new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>();

	public BookingCalendar(){

	}

	public static void main(String[] args){
		initializeCalendar();
		int year = 2015;
		String fradato = "2016-10-5";
		String tildato = "2016-10-20";
		String[] fradatoint = fradato.split("-");
		String[] tildatoint = tildato.split("-");
		boolean done = false;
		while(!done){
			capacity.get(Integer.parseInt(fradatoint[0])-year).get(index);
			
		}

		// Get the number of days in that month
//		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
//		System.out.println(daysInMonth);
//		System.out.println(year);
//		calendar = new GregorianCalendar(year, Calendar.FEBRUARY, 1);
//		daysInMonth= calendar.getActualMaximum(Calendar.DAY_OF_MONTH);      // 29
//		System.out.println(daysInMonth);
	}

	public static void initializeCalendar(){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for(int cap = 0;cap < 3;cap++){
			for(int total = 0;total < 12;total++){
				calendar = new GregorianCalendar(year, total, 1);
				int daysinMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
				for(int i = 0;i < 9;i++){
					booking.add(0);
				}
				for(int i = 0;i < daysinMonth;i++){
					day.add(booking);
				}
				month.add(day);
			}
			year++;
			capacity.add(month);
		}
	}
	public void addYear(){
		int year = Calendar.getInstance().get(Calendar.YEAR)+capacity.size()+1;
		for(int total = 0;total < 12;total++){
			calendar = new GregorianCalendar(year, total, 1);
			int daysinMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int i = 0;i < 9;i++){
				booking.add(0);
			}
			for(int i = 0;i < daysinMonth;i++){
				day.add(booking);
			}
			month.add(day);
		}
		year++;
		capacity.add(month);
//		january = Calendar.JANUARY;
//		february = Calendar.FEBRUARY;
//		march = Calendar.MARCH;
//		april = Calendar.APRIL;
//		may = Calendar.MAY;
//		june = Calendar.JUNE;
//		july = Calendar.JULY;
//		august = Calendar.AUGUST;
//		september = Calendar.SEPTEMBER;
//		october = Calendar.OCTOBER;
//		november = Calendar.NOVEMBER;
//		december = Calendar.DECEMBER;
	}

}
