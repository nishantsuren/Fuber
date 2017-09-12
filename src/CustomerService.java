import java.util.HashMap;
import java.util.Map;

public class CustomerService {
	
	private static Map<Integer, Customer> custMap = new HashMap<>();
	private static Map<Integer, Customer> activeCustMap = new HashMap<>();
	
	public void addNewCustomer(Customer cust){
		custMap.put(cust.getId(), cust);
	}
	
	public Customer getCustomer(int customerId){
		Customer cust = custMap.get(customerId);
		
		return cust;
	}
	
	public void associateCab(int custId, Cab cab){
		Customer cust = custMap.get(custId);
		if(cust != null){
			cust.setAssociatedCab(cab);
		}
	}
	
	public void startRide(int custId){
		Customer cust = custMap.get(custId);
		if(cust != null){
			custMap.remove(custId);
			activeCustMap.put(custId, cust);
			System.out.println("Ride started");
		}
		else{
			cust = activeCustMap.get(custId);
			if(cust != null)
				System.out.println("Ride already started");
			else
				System.out.println("Customer does not exist");
		}
	}
	
	public void endRide(int custId){
		Customer cust = activeCustMap.get(custId);
		if(cust != null){
			cust.setAssociatedCab(null);
			activeCustMap.remove(custId);
			custMap.put(custId, cust);
			System.out.println("Ride stopped");
		}
		else{
			cust = custMap.get(custId);
			if(cust != null)
				System.out.println("Ride already stopped");
			else
				System.out.println("Customer does not exist");
		}
	}
	
	public void updateLocation(int custId, Location location){
		Customer cust = custMap.get(custId);
		cust.setLocation(location);
	}

}
