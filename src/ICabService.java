
public interface ICabService {
	
	public double getDistance(int x1, int y1, int x2, int y2);
	
	public AbstractCab getAvailableCab(String type, Location location);
	
	public AbstractCab getCab(int cabId);
	
	public void updateLocation(int cabId, Location location);
	
	public void flipStatus(int cabId);
	
	public void addCab(AbstractCab cab);

}
