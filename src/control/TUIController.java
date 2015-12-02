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
					break;
				case "2" :
					System.out.println("Indtast navn:");
					name = getStringInput();
					break;
				case "3" :
					System.out.println("Indtast start dato:");
					name = getStringInput();
					break;
				case "4" :
					System.out.println("Indtast slut dato:");
					name = getStringInput();
					break;
				case "5" :
					break whileLoop;
					
			}
		}
		if (phone!=null && name!=null && startdate!=null && enddate!=null){
			// kald i main
		
		} else {
		
		}
		
	}
	
	public void deleteReservation(){
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
	
	public void checkIn(){
		
	}
	
	public void checkOut(){
		
	}
	
	
}
