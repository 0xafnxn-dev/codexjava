class Driver
{
	public static void main (String args[])
	{
	System.out.println("Driver.main() starts");
	OrderMgmt objMgmt = new OrderMgmt();
	
	objMgmt.placeOrder("IPHONE 18");
	System.out.println("Driver.main() ends");
	}

}