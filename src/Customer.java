
public class Customer extends AbstractCustomer{
	private int id;
	private Location location;
	private Location destination;
	private String status;
	
	public Customer(int id){
		this.id = id;
	}

	@Override
	public void setId(int id) {
		this.id=id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Location getDestination() {
		return this.destination;
	}

	@Override
	public void setDestination(Location location) {
		this.destination = location;
	}
	
}
