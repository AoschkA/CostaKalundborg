package logic;

import java.util.ArrayList;
import java.util.Arrays;

import entity.invoice.Invoice;
import entity.reservation.Reservation;

public class InvoiceLogic {
	ArrayList<Invoice> invoiceList;
	
	
	public InvoiceLogic(){
		
	}
	
	public int makeInvoice(String string){
		String[] reservationIDs = string.split(",");
		
		for (int i=0;i<reservationIDs.length;i++){
			for (i;)
		}
		ArrayList reservationIDsList= new ArrayList(Arrays.asList(reservationIDs));
		
		ArrayList<Reservation> reservationList= new ArrayList<Reservation>();
		for(Reservation r : reservationIDs){
		reservationList.add(
		}
		
		
		invoiceList.add(new Invoice(reservationIDsList))
		
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
