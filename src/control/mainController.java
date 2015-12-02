package control;

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
		case "tent": reservationLogic.makeTent(phonenumber, false, arrivalDate, departureDate, numChildren, numAdults, numDogs);
		return true;
		case "caravan": reservationLogic.makeCaravan(phonenumber, false, arrivalDate, departureDate, numChildren, 
				numAdults, numDogs, largeCampSite);
		return true;
		case "cottage": reservationLogic.makeCottage(phonenumber, false, arrivalDate, departureDate, numAdults, cottageType);
		return true;
		}
		return false;
	}
	
	public void deleteReservation(int customerID){
		reservationLogic.deleteReservation(reservationID);
	}
	public void changeReservation(int customerID, String arrivalDate, String departureDate) {
		Reservation r = reservationLogic.getReservation()
	}
	
	
	
	

}
