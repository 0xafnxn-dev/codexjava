class AddTwoNumber
{
	public static void main (String args[])
	{
	int number1 = Integer.parseInt(args[0]);
	int number2 = Integer.parseInt(args[1]);
	
	System.out.println("You entered the numbers : "+ args[0] +" "+ args[1]);
	
	int sumOfTwoNumber = AddTwoNumber.getSumOfTwoNumber(number1,number2);
	
	System.out.println(sumOfTwoNumber);
	}
	
	static int getSumOfTwoNumber(int number1,int number2)
	{
	int result = number1 + number2;
	return result;
	}
}