# Fuber

TestFuber.java contains the test cases to test the FUBER service.
It includes creating or customer and cabs.

Class FuberServiceApi is the main API which will be used to book/start/end a cab/ride

CabService class deals with all the operation related to cab
Similarly CustomerService calss deals with all customer related operations
and RideService deals with all ride related opearations.

Different types of cab is implemented by inheriting abstract cab class.
A property "type" makes different types of cabs possible with same functionality.
