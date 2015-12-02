package logic;

import java.util.ArrayList;

import entity.reservation.Caravan;
import entity.reservation.Cottage;
import entity.reservation.Reservation;
import entity.reservation.Tent;

public class ReservationLogic {
	private static ArrayList<Reservation> reservationList;
	
	public ReservationLogic() {
		reservationList = new ArrayList<Reservation>();
	}
	
	public void makeCaravan(String customerID, boolean arrived, String arrivalDate, String departureDate,
			int numChildren, int numAdults, int numDogs, boolean largeCampSite) {
		reservationList.add(new Caravan(customerID, arrived, arrivalDate, departureDate, 
				numChildren, numAdults, numDogs, largeCampSite));
	}
	public void makeTent(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numChildren, int numAdults, int numDogs) {
		reservationList.add(new Tent(customerID, arrived, arrivalDate, departureDate, 
				numChildren, numAdults, numDogs));
	}
	public void makeCottage(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numPersons, int cottageType) {
		reservationList.add(new Cottage(customerID, arrived, arrivalDate, departureDate, numPersons, cottageType));
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
			if (r.getId()==reservationID) reservationList.remove(r);
		}
	}
	public void deleteReservation(String customerID) {
		for (Reservation r: reservationList) {
			if (r.getCustomerID()==customerID) reservationList.remove(r);
		}
	}
}
