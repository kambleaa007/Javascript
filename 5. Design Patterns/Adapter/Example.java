public class Example {

	//
	// This example will take a European plug, and through the 
	// use of an "adapter" will allow it work with a UK socket.
	//
	
	public static void main(String[] args) {
		EuroPlug plugConnector = new EuroPlugImpl();
		UKSocket socket = new UKSocket();
		UKPlug ukAdapter = new EuroToUKPlugAdapter(plugConnector);
		socket.attach(ukAdapter);
	}
}