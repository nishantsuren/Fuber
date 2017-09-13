import java.util.UUID;

public class Ride extends AbstractRide{

	private UUID rideId;
	private int customerId;
	private int cabId;
	private Location startLocation;
	private Location endLocation;
	
	ICustomerService customerService;
	ICabService cabService;
	
	public Ride(int custId, int cabId, Location startLoc, Location endLoc){
		this.customerId = custId;
		this.cabId = cabId;
		this.startLocation = startLoc;
		this.endLocation = endLoc;
		this.cabService = new CabService();
		this.customerService = new CustomerService();
	}

	@Override
	public UUID startRide(){
		this.rideId = UUID.randomUUID();
		super.startEndRide(cabId, customerId, cabService, customerService);
		
		return this.rideId;
	}
	
	@Override
	public void endRide(){
		super.startEndRide(cabId, customerId, cabService, customerService);
	}

	@Override
	public Location getStartLocation() {
		return this.startLocation;
	}

	@Override
	public Location getEndLocaiton() {
		return this.endLocation;
	}

	@Override
	public UUID getRideId() {
		return this.rideId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public int getCabId() {
		return this.cabId;
	}

}
