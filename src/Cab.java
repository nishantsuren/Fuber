
public class Cab {
	
	int id;
	Location location;
	Location destination;
	Customer associatedCustomer;
	
	public Location getDestination() {
		return destination;
	}


	public void setDestination(Location destination) {
		this.destination = destination;
	}


	public Customer getAssociatedCustomer() {
		return associatedCustomer;
	}


	public void setAssociatedCustomer(Customer associatedCustomer) {
		this.associatedCustomer = associatedCustomer;
	}


	public Cab(int id, Location location){
		this.id = id;
		this.location = location;
		this.associatedCustomer = null;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}

}
