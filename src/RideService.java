import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RideService implements IRideService{
	
	private static Map<UUID, AbstractRide> rideMap = new HashMap<>();
	
	@Override
	public AbstractRide getRide(UUID rideId){
		AbstractRide ride = rideMap.get(rideId);
		
		return ride;
	}
	
	@Override
	public UUID startRide(AbstractRide ride){
		System.out.println("Starting ride for customer " + ride.getCustomerId() + " in cab "+ ride.getCabId());
		
		UUID rideId = ride.startRide();
		rideMap.put(rideId, ride);
		
		System.out.println("Ride ID generated: " + ride.getRideId());
		
		return rideId;
	}
	
	@Override
	public void endRide(AbstractRide ride){
		UUID rideId = ride.getRideId();
		
		System.out.println("Ending ride with ride ID: " + rideId);
		
		ride.endRide();
		rideMap.remove(rideId);
	}

}
