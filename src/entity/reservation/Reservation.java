package entity.reservation;

public abstract class Reservation {
	private static int idCounter = 0;
	private int id;
	private String customerID;
	private boolean arrived;
	private String arrivalDate;
	private String departureDate;
	private int powerConsumption;
	
	public Reservation(String customerID, boolean arrived, String arrivalDate, String departureDate) {
		id=idCounter++;
		this.customerID=customerID;
		this.arrived=arrived;
		this.arrivalDate=arrivalDate;
		this.departureDate=departureDate;
		powerConsumption=0;
	}
	public String getCustomerID() {return customerID;}
	public void setCustomerID(String customerID) {this.customerID = customerID;}
	public boolean isArrived() {return arrived;}
	public void setArrived(boolean arrived) {this.arrived = arrived;}
	public String getArrivalDate() {return arrivalDate;}
	public void setArrivalDate(String arrivalDate) {this.arrivalDate = arrivalDate;}
	public String getDepartureDate() {return departureDate;}
	public void setDepartureDate(String departureDate) {this.departureDate = departureDate;}
	public int getPowerConsumption() {return powerConsumption;}
	public void setPowerConsumption(int powerConsumption) {this.powerConsumption = powerConsumption;}
	public int getId() {return id;}
	
	
	

}
