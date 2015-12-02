package entity.reservation;

public class Caravan extends CampSite{
	private boolean largeCampSite;
	
	public Caravan(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numChildren, int numAdults, int numDogs, boolean largeCampSite) {
		super(customerID, arrived, arrivalDate, departureDate, numChildren, numAdults,
				numDogs);
		this.largeCampSite=largeCampSite;
	}

	public boolean isLargeCampSite() {return largeCampSite;}
	public void setLargeCampSite(boolean largeCampSite) {this.largeCampSite = largeCampSite;}

}
