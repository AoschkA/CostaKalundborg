package logic;

import java.util.ArrayList;
import java.util.Arrays;

import entity.invoice.Invoice;
import entity.reservation.Reservation;

public class InvoiceLogic {
	private static ArrayList<Invoice> invoiceList;
	private static ArrayList<Reservation> reservationList;
	
	
	public InvoiceLogic(ReservationLogic RL){
		invoiceList = new ArrayList<Invoice>();
		reservationList = RL.getReservationList();
	}
	
	public int makeInvoice(String reservations){
		String[] reservationIDs = reservations.split(",");
		ArrayList<Reservation> targetReservations = new ArrayList<Reservation>();
		for (Reservation r: reservationList){
		for (int i=0;i<reservationIDs.length;i++){
			if (r.getId()==Integer.parseInt(reservationIDs[i])) targetReservations.add(r);
			}
		}
		invoiceList.add(new Invoice(targetReservations));
		return targetReservations.size();
	}
	
	public int makeInvoice(ArrayList <Invoice> invoiceList){
		this.invoiceList = invoiceList;
		invoiceList.
	}
	
	public ArrayList<Invoice> getCustomerInvoices(String customerID){
		for (Invoice invoice : invoiceList){
			for(int i = 0;i<invoice.getReservationList().size();i++){
				if (invoice.getReservationList().get(i).getCustomerID() == customerID){
					invoiceList.add(invoice);
				}
			}
		}
		return invoiceList;
	}

	public ArrayList<Invoice> getInvoices() {
		return invoiceList;
	}
	
	
	
	
	
	
}
