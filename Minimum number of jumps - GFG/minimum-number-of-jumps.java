//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int steps = arr[0];
        int n = arr.length;
        int maxReachable = arr[0];
        int jumps = 1;
        if(maxReachable == 0){
            return -1;
        }
        for(int i=1; i<n; i++){
            if(i==n-1){
                return jumps;
            }
            maxReachable = Math.max(i+arr[i], maxReachable);
            steps--;
            if(steps==0){
                jumps++;
                if(i>= maxReachable){
                    return -1;
                }
                steps = maxReachable-i;
            }
        }
        return jumps;
    }
}