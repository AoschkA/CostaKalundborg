package logic;

import java.util.ArrayList;

import entity.invoice.Invoice;
import entity.reservation.Reservation;

public class InvoiceLogic {
	private static ArrayList<Invoice> invoiceList;
	
	
	public InvoiceLogic(){
		invoiceList = new ArrayList<Invoice>();
	}
	
	public int makeInvoice(String reservations, ArrayList<Reservation> reservationList){
		String[] reservationIDs = reservations.split(",");
		ArrayList<Reservation> targetReservations = new ArrayList<Reservation>();
		for (Reservation r: reservationList){
		for (int i=0;i<reservationIDs.length;i++){
			if (r.getId()==Integer.parseInt(reservationIDs[i])) targetReservations.add(r);
			}
		}
		Invoice i = new Invoice(targetReservations);
		invoiceList.add(i);
		return i.getId();
	}
	
	public int makeInvoice(ArrayList<Reservation> reservationList){
		Invoice i = new Invoice(reservationList);
		invoiceList.add(i);
		return i.getId();
	}
	
	public ArrayList<Invoice> getCustomerInvoices(String customerID){
		ArrayList<Invoice> targetList = new ArrayList<Invoice>();
		for (Invoice invoice : invoiceList){
			for(int i = 0;i<invoice.getReservationList().size();i++){
				if (invoice.getReservationList().get(i).getCustomerID() == customerID){
					targetList.add(invoice);
				}
			}
		}
		return targetList;
	}

	public ArrayList<Invoice> getInvoiceList() {
		return invoiceList;
	}
	
	
	
	
	
	
}
