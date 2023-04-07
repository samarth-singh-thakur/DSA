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
    public int findMaxSum(int arr[], int n, int[] dp){
        if(n==0) return arr[0];
        if(n<0){
            return 0;
        }
        
        if(dp[n]!=0) return dp[n];
        int oneHouse = arr[n]+ findMaxSum(arr, n-2, dp);
        int secondHouse = Integer.MIN_VALUE;
        
        secondHouse =  findMaxSum(arr, n-1,dp);
    
        dp[n] = Math.max(oneHouse, secondHouse);
        return dp[n];
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n];
        return findMaxSum(arr, n-1, dp);
    }
}