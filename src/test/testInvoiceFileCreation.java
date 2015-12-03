package test;

import logic.InvoiceLogic;
import logic.ReservationLogic;

public class testInvoiceFileCreation {
	public static void main(String[] args) {
		ReservationLogic RL = new ReservationLogic();
		InvoiceLogic IL = new InvoiceLogic();
		String phonenumber = "22002200";
		// RL.makeCampsite(phonenumber, false, "2016-04-04", "2016-06-05", 2, 2, 2, 1);
		RL.makeCottage(phonenumber, false, "2016-06-06", "2016-10-06", 6, 4);
		IL.makeInvoice(RL.getReservations(phonenumber));
	}

}
