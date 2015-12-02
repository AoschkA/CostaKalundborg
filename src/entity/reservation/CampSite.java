package entity.reservation;

public abstract class CampSite extends Reservation{
	private int numChildren;
	private int numAdults;
	private int numDogs;

	public CampSite(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numChildren, int numAdults, int numDogs) {
		super(customerID, arrived, arrivalDate, departureDate);
		this.numChildren=numChildren;
		this.numAdults=numAdults;
		this.numDogs=numDogs;
	}

	public int getNumChildren() {return numChildren;}
	public void setNumChildren(int numChildren) {this.numChildren = numChildren;}
	public int getNumAdults() {return numAdults;}
	public void setNumAdults(int numAdults) {this.numAdults = numAdults;}
	public int getNumDogs() {return numDogs;}
	public void setNumDogs(int numDogs) {this.numDogs = numDogs;}
}
