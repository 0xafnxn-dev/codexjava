class FundTransfer
{
	public static void main (String args[])
	{
	 System.out.println("Starting main()");
	 
	 // calling the method and passsing the value(Input)
	 boolean result = doTransaction(10,"9856876948","1234567889");
	 System.out.println("IS txn Successfull? "+ result);
	 System.out.println("Ending main()");
	
	}
	
	static boolean doTransaction(int amountToBetxn,String senderAccNo,String recieverAccNo)
	{
		System.out.println("Entered doTransaction()");
		System.out.println("Input Recieved "+ amountToBetxn +" "+ senderAccNo +" "+ recieverAccNo );
		//some biz logic will perform txn
		
		System.out.println("Exit doTransaction()");
		return true;
	}
}