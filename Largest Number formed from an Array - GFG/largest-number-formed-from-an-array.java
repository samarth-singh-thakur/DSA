//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
    StringBuilder stringBuilder = new StringBuilder();

    Arrays.sort(arr, (String a, String b) -> {
        String ab=a+b;
        String ba=b+a;
        return ab.compareTo(ba) > 0 ? -1 :1;
    });

    for(int i=0;i<arr.length;i++){
        stringBuilder.append(arr[i]);
    }
    if (stringBuilder.length()==0){
        return "0";
    }
    return stringBuilder.toString();
    }
}


 
