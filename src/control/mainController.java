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
	
	public String userExist(String phonenumber) {
		if (customerDB.getCustomer(phonenumber).getName()==null) return null;
		else return customerDB.getCustomer(phonenumber).getName();
	}
	public void createUser(String phonenumber, String name) {
		customerDB.addCustomer(name, phonenumber);
	}
	public boolean createReservation(String phonenumber, String arrivalDate, String departureDate, int persons, 
			int numChildren, int numAdults , int numDogs, int type){
		if (type < 3) 
			reservationLogic.makeCampsite
			(phonenumber, false, arrivalDate, departureDate, numChildren, numAdults, numDogs, type);
		else
			reservationLogic.makeCottage(phonenumber, false, arrivalDate, departureDate, numAdults, type);
		return true;
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
	public void changeReservation(int reservationID, String newDepartureDate) {
		reservationLogic.changeReservation(reservationID, newDepartureDate);
	}
	
	
}