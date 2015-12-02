package boundary;

public class TUI {

	public TUI () {
		
	}
	
	public void login (){
		System.out.println ("Indtast brugernavn");
		System.out.println("Indtast Kodeord");
	}

	
	public void mainMenu(){
		System.out.println("Hoved Menu");
		System.out.println("1. Ny Reservation");
		System.out.println("2. Slet Reservation");
		System.out.println("3. Ændre reservation");
		System.out.println("4. Tjek ind");
		System.out.println("5. Tjek ud");
		
	}
	
	public void newReservation (){
		System.out.println("Ny Reservation");
		System.out.println("1. Indtast kundes telefonnummer");
		System.out.println("2. Indtast kundens Navn");
		System.out.println("3. Fra dato YYYY-MM-DD");
		System.out.println("4. Til dato YYYY-MM-DD");
		System.out.println("5. Vis reservation");
		System.out.println("6. Tilbage til hovedmenu");
	}
	
	public void deleteReservation(){
		System.out.println("Slet Reservation");
		System.out.println("1. Indtast reservations id");
		System.out.println("2. Søg reservation på kundes telefonnummer");
		System.out.println("3. Tilbage til hovedmenu");
	}
	
	public void changeReservation(){
		System.out.println("Ændre Reservation");
		System.out.println("1. Indtast reservations id");
		System.out.println("2. Søg reservation på kundes telefonnummer");
		System.out.println("3. Tilbage til hovedmenu");
	}
	
	public void reservationID (){
		System.out.println("Reservation ID");
		System.out.println("1. Ændre fra dato");
		System.out.println("2. Ændre til dato");
		System.out.println("3. Vis reservation");
		System.out.println("4. Fortryd og tilbage til hovedmenu");
	}
	
	public void checkIn (){
		System.out.println("Tjek Ind");
		System.out.println("1. Indtast reservations id");
		System.out.println("2. Søg reservation på kundes telefonnummer");
		System.out.println("3. Tilbage til hovedmenu");
	}
	
	public void checkOut (){
		System.out.println("Tjek Ud");
		System.out.println("1. Indtast reservations id");
		System.out.println("2. Sog reservation paa kundes telefonnummer");
		System.out.println("3. Tilbage til hovedmenu");
	}
	
	public void print (){
		System.out.println("Print kvittering");
		System.out.println("1. Udskriv kvittering");
		System.out.println("2. Tilbage til hovedmenu");
	}
	
}
