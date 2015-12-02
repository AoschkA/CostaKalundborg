package tui;

public class TUI {

	public TUI () {
		
	}
	
	public void insertLogin (){
		System.out.println ("Indtast brugernavn");
	}
	
	public void insertCode(){
		System.out.println("Indtast Kodeord");
		
	}
	
	public void wrong(){
		System.out.println("Forkert brugernavn eller adgangskode. Prov igen!");
	}
	
	public void hovedMenu(){
		System.out.println("1. Ny Reservation");
		System.out.println("2. Slet Reservation");
		System.out.println("3. Tjek ind");
		System.out.println("4. Tjek ud");
		
	}
	
	public void nyReservation (){
		System.out.println("");
	}
}
