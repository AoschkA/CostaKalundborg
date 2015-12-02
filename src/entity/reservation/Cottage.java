package entity.reservation;

public class Cottage extends Reservation{
	private int numPersons;
	private int cottageType; 

	public Cottage(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numPersons, int cottageType) {
		super(customerID, arrived, arrivalDate, departureDate);
		this.numPersons=numPersons;
		this.cottageType=cottageType;
	}

	public int getNumPersons() {return numPersons;}
	public void setNumPersons(int numPersons) {this.numPersons = numPersons;}
	public int getCottageType() {return cottageType;}
	public void setCottageType(int cottageType) {this.cottageType = cottageType;}

}
