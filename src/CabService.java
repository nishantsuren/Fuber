import java.util.HashMap;
import java.util.Map;

public class CabService {
	
	private static Map<Integer, Cab> cabMap = new HashMap<>();
	private static Map<Integer, Cab> activeCabMap = new HashMap<>();
	
	public double getDistance(int x1, int y1, int x2, int y2){
		double x = Math.pow((x2-x1), 2);
		double y = Math.pow((y2-y1), 2);
		double dist = Math.sqrt((x+y));
		
		return dist;
	}
	
	public Cab getAvailableCab(Location location){
		int maxDistance = 8;
		int x = location.getX();
		int y = location.getY();
		
		Cab closestSoFar = null;
		double closestDist = -1;
		
		for(int cabId : cabMap.keySet()){
			Cab testCab = cabMap.get(cabId);
			int cx = testCab.getLocation().getX();
			int cy = testCab.getLocation().getY();
			
			double dist = getDistance(x,y,cx,cy);
			if(dist <= maxDistance && testCab.getAssociatedCustomer() == null){
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
		return closestSoFar;
	}
	
	public Cab getCab(int cabId){
		Cab cab = cabMap.get(cabId);
		
		return cab;
	}
	
	public void updateLocation(int cabId, Location location){
		Cab testCab = cabMap.get(cabId);
		if(testCab != null)
			testCab.setLocation(location);
		else
			System.out.println("Cab not available");
	}
	
	public void endRide(int cabId){
		Cab testCab = activeCabMap.get(cabId);
		if(testCab != null){
			testCab.setAssociatedCustomer(null);
			testCab.setLocation(testCab.getDestination());
			activeCabMap.remove(cabId);
			cabMap.put(cabId, testCab);
			System.out.println("Ride ended");
		}
		else{
			testCab = cabMap.get(cabId);
			if(testCab != null)
				System.out.println("Ride already stopped");
			else
				System.out.println("Cab does not exist");
		}
	}
	
	public void startRide(int cabId){
		Cab testCab = cabMap.get(cabId);
		if(testCab != null){
			cabMap.remove(cabId);
			activeCabMap.put(cabId, testCab);
			System.out.println("Ride started");
		}
		else{
			testCab = activeCabMap.get(cabId);
			if(testCab != null)
				System.out.println("Cab already active");
			else
				System.out.println("Cab does not exist");
		}
	}
	
	public void associateCustomer(int cabId, Customer customer){
		Cab testCab = cabMap.get(cabId);
		testCab.setAssociatedCustomer(customer);
	}
	
	
}
