package logic;

import java.util.ArrayList;

import entity.reservation.CampSite;
import entity.reservation.Cottage;
import entity.reservation.Reservation;

public class ReservationLogic {
	private static ArrayList<Reservation> reservationList;
	private BookingCalendarLogic bcl;

	public ReservationLogic() {
		reservationList = new ArrayList<Reservation>();
		bcl = new BookingCalendarLogic();
	}

	public ArrayList<String> makeCampsite(String customerID, boolean arrived, String arrivalDate, String departureDate,
			int numChildren, int numAdults, int numDogs, int type) {
		ArrayList<String> reservedDays = bcl.reservePeriod(arrivalDate, departureDate, type);
		if(reservedDays.get(0).endsWith("HIGH") || reservedDays.get(0).endsWith("LOW")){
			reservationList.add(new CampSite(reservedDays, customerID, arrived, arrivalDate, departureDate, 
					numChildren, numAdults, numDogs, type));
			return null;
		}
		else {return reservedDays;}
	}

	public ArrayList<String> makeCottage(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numPersons, int type) {
		ArrayList<String> reservedDays = bcl.reservePeriod(arrivalDate, departureDate, type);
		if(reservedDays.get(0).endsWith("HIGH") || reservedDays.get(0).endsWith("LOW")){
			reservationList.add(new Cottage(reservedDays, customerID, arrived, arrivalDate, departureDate, numPersons, type));
			return null;
		}
		else {return reservedDays;}
	}

	public ArrayList<Reservation> getReservation(String customerID) {
		ArrayList<Reservation> output = new ArrayList<Reservation>();
		for (Reservation r:reservationList) {
			if (r.getCustomerID().equals(customerID)) output.add(r);
		}
		return output;
	}

	public ArrayList<Reservation> getReservationList() { return reservationList;}

	public void deleteReservation(int reservationID) {
		for (Reservation r: reservationList) {
			if (r.getId()==reservationID) {
				bcl.deletePeriod(r.getArrivalDate(), r.getDepartureDate(), r.getType());
				reservationList.remove(r);
			}
		}
	}

	//	public void deleteReservation(String customerID) {
	//		for (Reservation r: reservationList) {
	//			if (r.getCustomerID()==customerID) reservationList.remove(r);
	//		}
	//	}

	public void changeReservation(){

	}
}
