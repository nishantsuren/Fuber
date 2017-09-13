import java.util.HashMap;
import java.util.Map;

public class CabService implements ICabService{
	
	private static Map<Integer, AbstractCab> cabMap = new HashMap<>();
	
	public double getDistance(int x1, int y1, int x2, int y2){
		double x = Math.pow((x2-x1), 2);
		double y = Math.pow((y2-y1), 2);
		double dist = Math.sqrt((x+y));
		
		return dist;
	}
	
	public AbstractCab getAvailableCab(String type, Location location){
		int maxDistance = 8;
		int x = location.getX();
		int y = location.getY();
		
		AbstractCab closestSoFar = null;
		double closestDist = -1;
		
		for(int cabId : cabMap.keySet()){
			AbstractCab testCab = cabMap.get(cabId);
			int cx = testCab.getLocation().getX();
			int cy = testCab.getLocation().getY();
			
			double dist = getDistance(x,y,cx,cy);
			if(dist <= maxDistance && testCab.getType() == type){
				if(closestSoFar == null){
					closestSoFar = testCab;
					closestDist = dist;
				}
				else{
					if(dist < closestDist){
						closestSoFar = testCab;
						closestDist = dist;
					}
				}
			}
		}
		if(closestSoFar == null)
			System.out.println("No Cab found");
		else{
			System.out.println("Cab found at distance " + closestDist);
			System.out.println("Cab ID " + closestSoFar.getId());
		}
		return closestSoFar;
	}
	
	public AbstractCab getCab(int cabId){
		AbstractCab cab = cabMap.get(cabId);
		
		return cab;
	}
	
	public void updateLocation(int cabId, Location location){
		AbstractCab testCab = cabMap.get(cabId);
		if(testCab != null)
			testCab.setLocation(location);
		else
			System.out.println("Cab not available");
	}

	@Override
	public void flipStatus(int cabId) {
		AbstractCab cab = cabMap.get(cabId);
		
		System.out.println("Changing cab status");
		System.out.println("Current status: " + cab.getStatus());
		
		if(cab.getStatus() == "ON_RIDE")
			cab.setStatus("AVAILABLE");
		else
			cab.setStatus("ON_RIDE");
		
		System.out.println("New status: " + cab.getStatus());
		
	}

	@Override
	public void addCab(AbstractCab cab) {
		cabMap.put(cab.getId(), cab);
	}
}
