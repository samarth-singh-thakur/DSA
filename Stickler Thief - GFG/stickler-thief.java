//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{   
    
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        if(n==1 || n==2){
            int secondElm = Integer.MIN_VALUE;
            if(n==2){
                secondElm = arr[1];
            }
            return Math.max(arr[0], secondElm);
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        // dp[1] = arr[1];
        for(int i=1; i<n; i++){
            int temp = arr[i];
            if(i>1) temp += dp[i-2];
            dp[i] = Math.max(temp, dp[i-1]);
        }
        return dp[n-1];
    }
}