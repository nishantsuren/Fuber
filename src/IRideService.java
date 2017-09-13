import java.util.UUID;

public interface IRideService {

	public AbstractRide getRide(UUID rideId);
	
	public UUID startRide(AbstractRide ride);
	
	public void endRide(AbstractRide ride);
}
