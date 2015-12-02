package entity.reservation;

public class Tent extends CampSite{

	public Tent(String customerID, boolean arrived, String arrivalDate,
			String departureDate, int numChildren, int numAdults, int numDogs) {
		super(customerID, arrived, arrivalDate, departureDate, numChildren, numAdults,
				numDogs);
	}

}
