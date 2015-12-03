package entity.invoice;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entity.invoice.Invoice;
import entity.reservation.Cottage;
import entity.reservation.Reservation;

public class Print {
	private static Invoice currentInvoice;
	
	public static void printInvoice(Invoice invoice) {
		currentInvoice=invoice;
		writeFile();
	}
	private static void writeFile() {
		String dbFile = "Invoices/invoice"+currentInvoice.getId();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(dbFile));
			printFile(bw);
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();} 
		finally {
			if (bw != null) try {bw.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	private static String createPrintString() {
		String finalprint = "Fakture nummer: "+currentInvoice.getId()+"\n"+"---------------------- \n";
		for (Reservation r: currentInvoice.getReservationList()){
			finalprint += "Kunde: "+r.getCustomerID()+"\n"+
						"Ankomst dato: "+r.getArrivalDate()+"\t"+"Afrejse dato: "+r.getDepartureDate()+"\n";
		}
		return finalprint;
	}
	private static void printFile(BufferedWriter bw) throws IOException {
		bw.write(createPrintString());
	}

}