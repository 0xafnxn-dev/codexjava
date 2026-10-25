class Payement
{
	public static void main(String args[])
	{
	int balance;
	balance = 400;		//Local variable
	int amountToBeTxn=10;  //Local variable
	int depositAmount = 200;
	System.out.println("Balance is : "+ balance);
	System.out.println("Transaction amount : "+ amountToBeTxn);
	System.out.println("Deposit amount : "+ depositAmount);
	paymentData(200);
	}
	static int paymentData(int depositAmount)
	{
		System.out.println("Amount to be Deposited :"+ depositAmount);
		return depositAmount;
	}
}