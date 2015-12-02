package entity.reservation;

public class Caravan extends CampSite{
	
	public Caravan(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numChildren, int numAdults, int numDogs, int type) {
		super(customerID, arrived, arrivalDate, departureDate, numChildren, numAdults,
				numDogs, type);
	}
}
