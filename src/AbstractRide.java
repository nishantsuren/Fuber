import java.util.UUID;

public abstract class AbstractRide {
	
	public void startEndRide(int cabId, int custId, ICabService cabService, ICustomerService custService){
		cabService.flipStatus(cabId);
		custService.flipStatus(custId);
	}
	
	public abstract UUID startRide();
	
	public abstract void endRide();
	
	public abstract Location getStartLocation();
	
	public abstract Location getEndLocaiton();
	
	public abstract UUID getRideId();
	
	public abstract int getCustomerId();
	
	public abstract int getCabId();

}
