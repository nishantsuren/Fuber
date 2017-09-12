
public class Customer {
	int id;
	Location location;
	Location destination;
	Cab associatedCab;
	
	public Customer(int id, Location location){
		this.id = id;
		this.location = location;
		this.associatedCab = null;
	}
	
	public Cab getAssociatedCab() {
		return associatedCab;
	}

	public void setAssociatedCab(Cab associatedCab) {
		this.associatedCab = associatedCab;
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

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}
}
