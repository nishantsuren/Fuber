import java.util.HashMap;
import java.util.Map;

public class CustomerService implements ICustomerService{
	
	private static Map<Integer, AbstractCustomer> custMap = new HashMap<>();
	
	@Override
	public void addNewCustomer(Customer cust){
		custMap.put(cust.getId(), cust);
	}
	
	@Override
	public AbstractCustomer getCustomer(int customerId){
		AbstractCustomer cust = custMap.get(customerId);
		
		return cust;
	}
	
	@Override
	public void updateLocation(int custId, Location location){
		AbstractCustomer cust = custMap.get(custId);
		cust.setLocation(location);
	}

	@Override
	public void flipStatus(int custId) {
		AbstractCustomer cust = custMap.get(custId);
		
		System.out.println("Changing customer status");
		System.out.println("Current status: " + cust.getStatus());
		
		if(cust.getStatus() == "ON_RIDE")
			cust.setStatus("AVAILABLE");
		else
			cust.setStatus("ON_RIDE");
		
		System.out.println("New status: " + cust.getStatus());
	}

	@Override
	public void addCustomer(AbstractCustomer customer) {
		custMap.put(customer.getId(), customer);
	}
	
}
