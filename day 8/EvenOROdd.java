import java.util.Scanner;
class Solution {
	
	
	  public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
       boolean evenOrOdd = isEven(n);
       System.out.println(evenOrOdd);
    }
        
    static boolean isEven(int n) {
        
        // code here
        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
        
     }
  
}