import java.util.UUID;

public class TestFuber {
	
	public static void main(String args[]){
		ICabService cabService = new CabService();
		ICustomerService customerService = new CustomerService();
		
		Location cabLocOne = new Location(2, 4);
		Location cabLocTwo = new Location(22,10);
		Location cabLocThree = new Location(3,5);
		Location cabLocFour = new Location(19,11);
		
		AbstractCab normalCabOne = new Cab(111, "NORMAL");
		AbstractCab pinkCabOne = new Cab(881, "PINK");
		AbstractCab normalCabTwo = new Cab(112, "NORMAL");
		AbstractCab pinkCabTwo = new Cab(882, "PINK");
		
		normalCabOne.setLocation(cabLocOne);
		pinkCabOne.setLocation(cabLocTwo);
		normalCabTwo.setLocation(cabLocThree);
		pinkCabTwo.setLocation(cabLocFour);
		
		cabService.addCab(normalCabOne);
		cabService.addCab(normalCabTwo);
		cabService.addCab(pinkCabOne);
		cabService.addCab(pinkCabTwo);

		Location custLocOne = new Location(1, 1);
		Location custLocTwo = new Location(3,7);
		
		AbstractCustomer custOne = new Customer(4001);
		AbstractCustomer custTwo = new Customer(4005);
		AbstractCustomer custThree = new Customer(4009);
		
		custOne.setLocation(custLocOne);
		custTwo.setLocation(custLocTwo);
		
		customerService.addCustomer(custOne);
		customerService.addCustomer(custTwo);
		customerService.addCustomer(custThree);
		
		/**
		 * TESTING FUBER SERVICE
		 */
		
		/*
		 * TESTING NORMAL CAB
		 */
		FuberServiceApi fuberService = new FuberServiceApi();
		System.out.println("TESTING NORMAL CAB");
		AbstractCab requestNormalCab = fuberService.requestCab(4001, "NORMAL");
		
		if(requestNormalCab != null){
			System.out.println("Cab ID recived " + requestNormalCab.getId());
			
			UUID rideId = fuberService.startRide(4001, requestNormalCab.getId(), new Location(12,45));
			System.out.println("Ride ID recived " + rideId);
			
			fuberService.endRide(rideId);
			
			fuberService.updateCabLocation(requestNormalCab.getId(), new Location(12, 45));
		}
		
		/*
		 * TESTING PINK CAB
		 */
		System.out.println("\n");
		System.out.println("TESTING NOT AVAILABLE PINK CAB");
		AbstractCab requestPinkCab = fuberService.requestCab(4005, "PINK");
		
		if(requestPinkCab != null){
		
			System.out.println("Cab ID recived " + requestPinkCab.getId());
			
			UUID pinkRideId = fuberService.startRide(4005, requestPinkCab.getId(), new Location(32,18));
			System.out.println("Ride ID recived " + pinkRideId);
			
			fuberService.endRide(pinkRideId);
			
			fuberService.updateCabLocation(requestPinkCab.getId(), new Location(9, 9));
		}
		
		/*
		 * MAKING PINK CAB WITHIN RANGE
		 */
		System.out.println("\n");
		System.out.println("TESTING PINK CAB");
		fuberService.updateCustomerLocation(4005, new Location(15,9));
		requestPinkCab = fuberService.requestCab(4005, "PINK");
		
		if(requestPinkCab != null){
		
			System.out.println("Cab ID recived " + requestPinkCab.getId());
			
			UUID pinkRideId = fuberService.startRide(4005, requestPinkCab.getId(), new Location(32,18));
			System.out.println("Ride ID recived " + pinkRideId);
			
			fuberService.endRide(pinkRideId);
			
			fuberService.updateCabLocation(requestPinkCab.getId(), new Location(9, 9));
		}
		
		/*
		 * GETTING NEWLY AVAILABLE CAB
		 */
		System.out.println("\n");
		System.out.println("TESTING NORMAL CAB WHICH JUST ENDED A RIDE");
		fuberService.updateCustomerLocation(4009, new Location(14,40));
		requestNormalCab = fuberService.requestCab(4009, "NORMAL");
		
		if(requestNormalCab != null){
			System.out.println("Cab ID recived " + requestNormalCab.getId());
			
			UUID rideId = fuberService.startRide(4009, requestNormalCab.getId(), new Location(11,12));
			System.out.println("Ride ID recived " + rideId);
			
			fuberService.endRide(rideId);
			
			fuberService.updateCabLocation(requestNormalCab.getId(), new Location(11, 12));
		}
		
		
	}

}
