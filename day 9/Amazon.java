
	// Use case : 
	// -	Zepto/amazon  get free delivery if order value is more than 500.
	// -	Same day delivery if you are amazon prime user
	// -	3% transaction charges if transaction amount is more than 2000
	
import java.util.Scanner;
class Amazon
{
	public static void main (String args[]) throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Amazon");
		System.out.println("Enter the details amount");
		int orderAmount = sc.nextInt();
		System.out.println("You have confirmed this order of amount : " + orderAmount);
		System.out.println("order is Processing..........");
		Thread.sleep(7000);
		System.out.println("order is confirmed!");
		
		var orderDetails = priceOfOrder(orderAmount);
		System.out.println(orderDetails);
		System.out.println("Are you prime member?");
		
		boolean isPrime = sc.nextBoolean();
		
		String deliveryType = getDeliveryType(isPrime);
		System.out.println(deliveryType);
		System.out.println("Total amount to be paid : ");
	}
	
	static String priceOfOrder(int orderAmount)
	{
		if(orderAmount >= 500){
			return "free delvirey";
		}
		else
			return "Delivery charge: 40";
	}
		static String getDeliveryType(boolean isPrime)
	{
		if(isPrime)
		{
			return "Same Day Delivery";
			}
		else
		{
			return "Standard Delivery";
		}
	}	
}
	