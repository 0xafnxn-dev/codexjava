public class GoodMg
{	
	public static void main(String[]args)
{
	System.out.println ("GOOD MORNING!");
		doNothing();   // Function Invocation   
}
	//Function definition
	 static void doNothing()
	{
		String message = "Good Morning India!";
		PrintMessage("GM India!");
		PrintMessage(message);
 	}
	static String PrintMessage(String message)  
	{
		System.out.println(message);
		return message;
	}
}