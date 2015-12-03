package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import boundary.TUI;
import entity.reservation.Reservation;

public class TUIController {
	private BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	private TUI TUI = new TUI();
	private mainController mainController;
	
	public TUIController(mainController mainController){
		this.mainController = mainController;
	}
	
	public String getStringInput() {
		String input = "";
		try{
			input = inFromUser.readLine();
		} catch (IOException e) {
			System.out.println("Ugyldigt input!");
			return getStringInput();
		}
		return input;
	}
	
	
	public String mainMenuOptions(){
		TUI.mainMenu();
		String input = getStringInput();
	
		switch (input){
			case "1" : newReservation();	break;
			case "2" : deleteReservation();	break;
			case "3" : changeReservation(); break;
			case "4" : checkIn();			break;
			case "5" : checkOut();			break;
		}
		
		return input;
	}
	
	public void newReservation(){		
		String phone = null;
		String name = null;
		String startdate = null;
		String enddate = null;
		
		whileLoop:
		while(phone==null && name==null && startdate==null && enddate==null){
			TUI.newReservation();
			String input = getStringInput();
	
			switch(input){
				case "1" : 
					System.out.println("Indtast telefon:");
					phone = getStringInput();
					if(mainController.userExist(phone))
						
						
					break;
				case "2" :
					System.out.println("Indtast navn:");
					name = getStringInput();
					break;
				case "3" :
					System.out.println("Indtast start dato:");
					startdate = getStringInput();
					break;
				case "4" :
					System.out.println("Indtast slut dato:");
					enddate = getStringInput();
					break;
				case "5" : //Skal rettes til grundtype
					
				case "6" : break whileLoop;
					
			}
		}
		if (phone!=null && name!=null && startdate!=null && enddate!=null){
			// kald i main
		
		} else {
		
		}
		
	}
	
	//Finder ud af hvad for noget info der skal bruges ud fra typen af grund. 
	public void infoFromRentType()
	
	public void deleteReservation(){
		TUI.deleteReservation();
		String resID = null;
		String phoneNr = null;
		String[][] resInfo = null;
		
		whileLoop:
		while(true){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Indtast reservations ID:");
			resID = getStringInput();
			int resIDint = Integer.parseInt(resID);
			mainController.deleteReservation(resIDint);
			break;
		case "2" :
			System.out.println("Indtast telefonnummer:");
			phoneNr = getStringInput();
			resInfo = mainController.findReservationID(phoneNr);
			
			for(int i=0;i<resInfo.length;i++){
			System.out.println("");
			System.out.println("Information om reservation: " + resInfo[i]);
			System.out.println("Reservations ID: " + resInfo[i][0]);
			System.out.println("Start på periode: " + resInfo[i][1]);
			System.out.println("Slut på periode: " + resInfo[i][2]);
			System.out.println("");
			}
			break;
		case "3" :
			break whileLoop;
		}
		}
	}
	
	public void changeReservation(){
		TUI.changeReservation();
		String resID = null;
		String phoneNr = null;
		
		whileLoop:
		while(true){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Indtast reservations ID:");
			resID = getStringInput();
			// Metode til slet
			break;
		case "2" :
			System.out.println("Indtast telefonnummer:");
			phoneNr = getStringInput();
			// Metode til at finde ID ud fra tlfnr
			break;
		case "3" :
			break whileLoop;
		}
		}
		
	}
	
	public void changeReservationInner(String resID){
		TUI.reservationID();
		System.out.println("Ændrer for: " + resID);
		String fromdate = null;
		String todate = null;
		
		whileLoop:
		while(fromdate == null && todate == null){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Fra dato:");
			fromdate = getStringInput();
			// Metode til slet
			break;
		case "2" :
			System.out.println("Til dato:");
			todate = getStringInput();
			// Metode til at finde ID ud fra tlfnr
			break;
		case "3" : 
			break whileLoop;
			
		}
		}
		if(fromdate != null  && todate == null){
			//Gem ny dato for reservationsID.
		}
		
	}
	
	public void checkIn(){
		TUI.deleteReservation();
		String resID = null;
		String phoneNr = null;
		
		whileLoop:
		while(true){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Indtast reservations ID:");
			resID = getStringInput();
			// Metode til indtjekning ud fra reservations ID
			break;
		case "2" :
			System.out.println("Indtast telefonnummer:");
			phoneNr = getStringInput();
			// Metode til at finde ID ud fra tlfnr
			break;
		case "3" :
			break whileLoop;
		}
		}
	}
	
	public void checkOut(){
		TUI.deleteReservation();
		String resID = null;
		String phoneNr = null;
		
		whileLoop:
		while(true){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Indtast reservations ID:");
			resID = getStringInput();
			// Metode til udtjekning ud fra reservations ID
			break;
		case "2" :
			System.out.println("Indtast telefonnummer:");
			phoneNr = getStringInput();
			// Metode til at finde ID ud fra tlfnr
			break;
		case "3" :
			break whileLoop;
		}
		}
	}
	
	public void login(){
		TUI.login();
		String username = null;
		String password = null;
		
		whileLoop:
		while(true){
			String input = getStringInput();
		switch(input){
		case "1" : 
			System.out.println("Indtast brugernavnet");
			username = getStringInput();
			break;
		case "2" : 
			System.out.println("Indtast kodeordet");
			password = getStringInput();
			break;
		}
		if(username != null && password != null)
			// if(mainController.checkLogin()) return boolean 
				break whileLoop;
			
			
		}
		mainMenuOptions();
	}
}
