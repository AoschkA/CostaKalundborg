package entity.reservation;

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
	private int baseYear = 2015;
	protected enum Type {Caravan, LargeCaravan, Tent, LuxuryCottage, LuxuryCottagePatio, LargeCottage, MediumCottage, SmallCottage};
	protected int[] maxCapacities = {100, 100, 100, 68-65, 45-44, 2, 2+30-27, 9-6};

	public BookingCalendar(){
		initializeCalendar();
	}

	public static void main(String[] args){
		//		initializeCalendar();
		//		int year = 2015;
		//		String fradato = "2016-10-5";
		//		String tildato = "2016-10-20";
		//		String[] fradatoint = fradato.split("-");
		//		String[] tildatoint = tildato.split("-");
	}

	public ArrayList<String> getOccupiedDays(String arrivalDate, String departureDate, int type ){
		ArrayList<String> occupiedDates = new ArrayList<String>();
		
		int[] dates = parseDates(arrivalDate, departureDate);
		
		int startYear=dates[0]-baseYear;
		int startMonth=dates[1]-1;
		int startDay=dates[2]-1;
		int endYear=dates[3]-baseYear;
		int endMonth=dates[4]-1;
		int endDay;
		int currentDay=0;
		
		while(endYear>capacity.size()-1){
			addYear();
		}

		for(int currentYear=startYear; currentYear<=endYear; currentYear++){
			for(int currentMonth=startMonth; currentMonth<=endMonth; currentMonth++){
				if(startMonth==endMonth){
					currentDay=startDay;
					endDay=dates[5]-1;
				}
				else if(currentMonth==startMonth){
					currentDay=startDay;
					endDay=capacity.get(currentYear).get(currentMonth).size();
				}
				else if (currentMonth==endMonth){
					currentDay=0;
					endDay = dates[5]-1;
				} else {
					currentDay=0;
					endDay=capacity.get(currentYear).get(currentMonth).size();
				}
				while(currentDay<endDay){
					if(capacity.get(currentYear).get(currentMonth).get(currentDay).get(type)==maxCapacities[type]){
						occupiedDates.add(currentYear + "-" + currentMonth + "-"+ currentDay);
					}
					currentDay++;
				}
			}
		}
		return occupiedDates;
	}

	public ArrayList<String> setReservation(String arrivalDate, String departureDate, int type, int value){
		ArrayList<String> result = new ArrayList<>();
		int[] dates = parseDates(arrivalDate, departureDate);
		int startYear=dates[0]-baseYear;
		int startMonth=dates[1]-1;
		int startDay=dates[2]-1;
		int endYear=dates[3]-baseYear;
		int endMonth=dates[4]-1;
		int endDay;
		int currentDay=0;

		for(int currentYear=startYear; currentYear<=endYear; currentYear++){
			for(int currentMonth=startMonth; currentMonth<=endMonth; currentMonth++){
				if(startMonth==endMonth){
					currentDay=startDay;
					endDay=dates[5]-1;
				}
				else if(currentMonth==startMonth){
					currentDay=startDay;
					endDay=capacity.get(currentYear).get(currentMonth).size();
				}
				else if (currentMonth==endMonth){
					currentDay=0;
					endDay = dates[5]-1;
				} else {
					currentDay=0;
					endDay=capacity.get(currentYear).get(currentMonth).size();
				}
				while(currentDay<endDay){
					if(capacity.get(currentYear).get(currentMonth).get(currentDay).get(type)<maxCapacities[type]){
						capacity.get(currentYear).get(currentMonth).get(currentDay).add(value);
					}
					if ((currentMonth==6 && currentDay>=12) || (currentMonth==8 && currentDay<=16)){
						result.add(currentYear + "-" + currentMonth + "-"+ currentDay + "HIGH");
					}
					else {
						result.add(currentYear + "-" + currentMonth + "-"+ currentDay + "LOW");
					}
					currentDay++;
				}
			}
		}
		return result;
	}

	// Get the number of days in that month
	//		int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
	//		System.out.println(daysInMonth);
	//		System.out.println(year);
	//		calendar = new GregorianCalendar(year, Calendar.FEBRUARY, 1);
	//		daysInMonth= calendar.getActualMaximum(Calendar.DAY_OF_MONTH);      // 29
	//		System.out.println(daysInMonth);
	//}

	private void initializeCalendar(){
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

	private void addYear(){
		int year = Calendar.getInstance().get(Calendar.YEAR)+capacity.size()+1;
		for(int total = 0;total < 12;total++){
			calendar = new GregorianCalendar(year, total, 1);
			int daysinMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int i = 0;i < 8;i++){
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
	
	private int[] parseDates(String arrivalDate, String departureDate){
		String[] firstDateString = arrivalDate.split("-");
		String[] lastDateString = departureDate.split("-");
		int[] dates = new int[6];

		for(int i=0; i<3; i++){
			dates[i] = Integer.parseInt(firstDateString[i]);
		}
		for(int i=0; i<3; i++){
			dates[i+3] = Integer.parseInt(lastDateString[i]);
		}
		return dates;
	}
}