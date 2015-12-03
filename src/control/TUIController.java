package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import boundary.TUI;
import entity.reservation.Reservation;

public class TUIController {
	private BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	private TUI TUI = new TUI();
	private MainController mainController;

	public TUIController(MainController mainController){
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
		default : System.out.println("Forkert tal."); break;
		}

		return input;
	}

	public void newReservation(){		
		String phone = null;
		String name = null;
		String startdate = null;
		String enddate = null;
		int groundtype = 0;
		String renttypestring;
		int[] renttypeinfo = null;
		int type = 0;

		whileLoop:
			while(type == 0){
				TUI.newReservation();
				String input = getStringInput();

				switch(input){
				case "1" : 
					System.out.println("Indtast telefon:");
					phone = getStringInput();
					name = mainController.userExist(phone);	
					if(!name.equals("")){
						System.out.println("Navnet " + name + " eksisterer i systemet, indtastning af navn er unødvendigt.");
						break;
					}
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
				case "5" : 
					System.out.println("Indtast grundtype, (1) for Cottage (2) for Campsite. ");
					groundtype = Integer.parseInt(getStringInput());

					if(groundtype != 1 || groundtype != 2){
						System.out.println("Forkert input.");
					}
					else
					{
//						if(groundtype == 1)
//							renttypestring = "cottage";
//						else
//							renttypestring = "campsite";
						renttypeinfo = infoFromRentType(groundtype);
					}					
					break;

				case "6" :
					System.out.println("Type af grund: ");
					type = Integer.parseInt(getStringInput());
					break;

				case "7" : break whileLoop;
				default : System.out.println("Forkert tal."); break;
				}
			}

		if (phone!=null && name!=null && startdate!=null && enddate!=null && renttypeinfo != null){
			mainController.createReservation(phone, startdate, enddate, renttypeinfo[0] ,renttypeinfo[1], renttypeinfo[2], renttypeinfo[3], type);

		} else {
			System.out.println("Fejl");
		}

	}

	//Finder ud af hvad for noget info der skal bruges ud fra typen af grund. 
	public int[] infoFromRentType(int renttype){
		int[] renttypeinfo = new int[4];
		renttypeinfo[0] = 0;
		renttypeinfo[1] = 0;
		renttypeinfo[2] = 0;
		renttypeinfo[3] = 0;

		if(renttype == 1){
			TUI.CottageInfo();
			String input = getStringInput();

			innerWhileLoop:
				while(renttypeinfo[0] == 0){
					switch (input){
					case "1" : 
						System.out.println("Indtast antal personer:");
						renttypeinfo[0] = Integer.parseInt(getStringInput());
						break;
					case "2" :
						break innerWhileLoop;
					default: System.out.println("Forkert tal");
					}
				}
		}

		if(renttype == 2){
			TUI.CampSiteInfo();
			String input = getStringInput();

			innerWhileLoop:
				while(true){
					switch (input){
					case "1" :
						System.out.println("Indtast antal voksne:");
						renttypeinfo[2] = Integer.parseInt(getStringInput());
					case "2" :
						System.out.println("Indtast eventuelle antal børn: ");
						renttypeinfo[1] = Integer.parseInt(getStringInput());
					case "3" :
						System.out.println("Indtast eventuelle antal hunde:");
						renttypeinfo[3] = Integer.parseInt(getStringInput());
					case "4" : 
						break innerWhileLoop;
					default : System.out.println("Forkert tal");
					}
				}	
		}
		return renttypeinfo;
	}


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
				default : System.out.println("Forkert tal."); break;
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
					// Metode til at rykke reservation
					break;
				case "2" :
					System.out.println("Indtast telefonnummer:");
					phoneNr = getStringInput();
					// Metode til at finde ID ud fra tlfnr
					break;
				case "3" :
					break whileLoop;
				default : System.out.println("Forkert tal."); break;
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
				default : System.out.println("Forkert tal."); break;

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
				default : System.out.println("Forkert tal."); break;
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
				default : System.out.println("Forkert tal."); break;
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
				default : System.out.println("Forkert tal."); break;
				}
				if(username != null && password != null){
					if(mainController.checklogin(username, password)){
						break whileLoop;
					}
					else{ System.out.println("Brugeren eksisterer ikke."); }}
				else{ System.out.println("Du har glemt at indskrive et brugernavn eller adgangskode.");}


			}
		mainMenuOptions();
	}
}
