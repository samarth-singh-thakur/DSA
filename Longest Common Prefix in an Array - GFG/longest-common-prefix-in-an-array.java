//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        int smallestLength = Integer.MAX_VALUE;
        int smallestLengthStringPrt = 0;
        for(int i=0; i<arr.length;i++){
            if(smallestLength>arr[i].length()){
                smallestLength = arr[i].length();
                smallestLengthStringPrt = i;
            }
        }
        
        String ans = "";
        for(int i=0; i<arr[smallestLengthStringPrt].length(); i++){
            for(int j=0; j<arr.length; j++){
                String s = arr[j];
                // System.out.println(s);
                if(s.charAt(i)!=arr[smallestLengthStringPrt].charAt(i)){
                    ans = arr[smallestLengthStringPrt].substring(0,i);
                    if(ans.length() ==0){
                        return "-1";
                    }else{
                        return ans;
                    }
                }else{
                    continue;
                }
            }
        }
        
        return arr[smallestLengthStringPrt];
        
    }
}