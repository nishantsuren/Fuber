import java.util.UUID;

public class FuberServiceApi {
	
	ICabService cabService;
	ICustomerService customerService;
	IRideService rideService;
	
	public FuberServiceApi(){
		cabService = new CabService();
		customerService = new CustomerService();
		rideService = new RideService();
	}
	
	public AbstractCab requestCab(int custId, String type){
		System.out.println("Fetching cab of type " + type + " for Customer " + custId);
		
		AbstractCustomer customer = customerService.getCustomer(custId);
		AbstractCab cab = cabService.getAvailableCab(type, customer.getLocation());
		
		return cab;
	}
	
	public UUID startRide(int custId, int cabId, Location destination){
		AbstractCustomer customer = customerService.getCustomer(custId);
		System.out.println("Starting ride for customer "
				+ custId + " from (" + customer.getLocation().getX() + ","
						+ customer.getLocation().getY() + ") to ("
								+ destination.getX() + "," + destination.getY() + ")"
										+ " in cab" + cabId);
		
		Ride ride = new Ride(custId, cabId, customer.getLocation(), destination);
		
		UUID rideId = rideService.startRide(ride);
		
		return rideId;
	}
	
	public void endRide(UUID rideId){
		System.out.println("Ending ride " + rideId);
		
		AbstractRide ride = rideService.getRide(rideId);
		rideService.endRide(ride);
	}
	
	public void updateCabLocation(int cabId, Location location){
		System.out.println("Updating cab location");
		AbstractCab cab = cabService.getCab(cabId);
		if(cab.getLocation() != null)
			System.out.println("Current location " + cab.getLocation().getX() + "," + cab.getLocation().getY());
		cab.setLocation(location);
		System.out.println("New location " + cab.getLocation().getX() + "," + cab.getLocation().getY());
	}
	
	public void updateCustomerLocation(int custId, Location location){
		System.out.println("Updating customer location");
		AbstractCustomer cust = customerService.getCustomer(custId);
		if(cust.getLocation() != null)
			System.out.println("Current location " + cust.getLocation().getX() + "," + cust.getLocation().getY());
		cust.setLocation(location);
		System.out.println("Current location " + cust.getLocation().getX() + "," + cust.getLocation().getY());
	}

}
