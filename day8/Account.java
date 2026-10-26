class Account
{
	int balance = 500; //instance variable   //objectname.variablename
	static int intRate = 600; //static variable  //className.variablename
	
	public static void main(String args[])
	{ 
			//stack //heap
	Account  acc = new Account();
	System.out.println("Balance is :"+acc.balance);  //dot(.) operator
	System.out.println("Balance is :"+Account.intRate); //dot(.) operator
	}
}