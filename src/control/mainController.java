package control;

import java.util.ArrayList;

import entity.login.Customer;
import entity.login.CustomerDB;
import entity.reservation.Reservation;
import logic.InvoiceLogic;
import logic.LoginLogic;
import logic.ReservationLogic;

public class mainController {
	private ReservationLogic reservationLogic = new ReservationLogic();
	private InvoiceLogic invoiceLogic = new InvoiceLogic();
	private LoginLogic loginLogic = new LoginLogic();
	private TUIController tuiController = new TUIController(this);
	private CustomerDB customerDB = new CustomerDB();
	
	public mainController() {
			
	}
	
	public boolean userExist(String phonenumber) {
		if (customerDB.getCustomer(phonenumber)==null) return false;
		else return true;
	}
	public boolean createReservation(String phonenumber, String name, String arrivalDate, String departureDate, 
			String type, int numChildren, int numAdults, int numDogs, boolean largeCampSite, int cottageType){
		Customer c; 
		if (name==null) c = customerDB.getCustomer(phonenumber);
		else customerDB.addCustomer(name, phonenumber);
		switch (type) {
		case "tent": reservationLogic.makeCampsite(phonenumber, false, arrivalDate, departureDate, numChildren, numAdults, numDogs, 0);
		return true;
		case "caravan": reservationLogic.makeCampsite(phonenumber, false, arrivalDate, departureDate, numChildren, 
				numAdults, numDogs, 2);
		return true;
		case "cottage": reservationLogic.makeCottage(phonenumber, false, arrivalDate, departureDate, numAdults, cottageType);
		return true;
		}
		return false;
	}
	
	public void deleteReservation(int reservationID){
		reservationLogic.deleteReservation(reservationID);
	}
	public String[][] findReservationID(String phonenumber) {
		ArrayList<Reservation> reservations = reservationLogic.getReservations(phonenumber);
		String[][] output = new String[reservations.size()][3];
		for (int i=0; i<reservations.size(); i++) {
			output[i][0] = Integer.toString(reservations.get(i).getId());
			output[i][1] = reservations.get(i).getArrivalDate();
			output[i][2] = reservations.get(i).getDepartureDate();
		}
		return output;
	}
	
	public void checkIn(int reservationID) {
		reservationLogic.getReservation(reservationID).setArrived(true);
	}
	
	public void checkOut(String phonenumber) {
		ArrayList<Reservation> targetReservations = new ArrayList<Reservation>();
		for (Reservation r: reservationLogic.getReservations(phonenumber)) {
			if (r.isArrived()) {
				targetReservations.add(r);
				reservationLogic.deleteReservation(r.getId());
			}
		}
		invoiceLogic.makeInvoice(targetReservations);
	}
	
	
}