class AdditionOfNumber
{
	public static void main (String args[])
	{
		String num1 = args[0];
		String num2 = args[1];
		 
		int num1Int = Integer.parseInt(num1); 
		int num2Int = Integer.parseInt(num2); 
		int num3 = num1Int + num2Int;
		
		System.out.println("Addition Of Number is : "+ num3);
	}
}