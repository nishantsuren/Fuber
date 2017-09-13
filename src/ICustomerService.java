
public interface ICustomerService {

	public void addNewCustomer(Customer cust);
	
	public AbstractCustomer getCustomer(int customerId);
	
	public void updateLocation(int custId, Location location);
	
	public void flipStatus(int custId);
	
	public void addCustomer(AbstractCustomer customer);
}
