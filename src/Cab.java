
public class Cab extends AbstractCab{
	
	private int id;
	private Location location;
	private String type;
	private String status;

	public Cab(int id, String type){
		this.id = id;
		this.type = type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
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

}
