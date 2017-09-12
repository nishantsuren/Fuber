
public class FuberServiceApi {
	
	CabService cabService;
	CustomerService customerService;
	
	public FuberServiceApi(){
		cabService = new CabService();
		customerService = new CustomerService();
	}
	
	public Cab requestCab(int custId, Location destination){
		Customer cust = customerService.getCustomer(custId);
		cust.setDestination(destination);
		Location custLocation = cust.getLocation();
		Cab cab = cabService.getAvailableCab(custLocation);
		cab.setAssociatedCustomer(cust);
		cust.setAssociatedCab(cab);
		
		return cab;
	}
	
	public void startRide(int custId, int cabId){
		Customer cust = customerService.getCustomer(custId);
		Cab cab = cabService.getCab(cabId);
		
		cab.setDestination(cust.getDestination());
		
		customerService.startRide(custId);
		cabService.startRide(cabId);
	}
	
	public void endRide(int custId, int cabId){
		customerService.endRide(custId);
		cabService.endRide(cabId);
	}

}
