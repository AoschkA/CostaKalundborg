package logic;

import java.util.ArrayList;

import entity.reservation.Reservation;

public class ReservationLogic {
	private static ArrayList<Reservation> reservationList;
	
	public ReservationLogic() {
		reservationList = new ArrayList<Reservation>();
	}
	
	// makeReservation()
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
}
