//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);
                
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];
                
                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean findLocalMaxima=false;
        int localMinimaPtr = 0;
        int localMaximaPtr = 0;
        if(A[0]<A[1]){
            findLocalMaxima = true;
        }
        while(localMaximaPtr<n){
            if(findLocalMaxima){
                //find local maxima
                for(int i=localMinimaPtr+1; i<n; i++){
                    if(i == n-1){
                        if(A[i-1]<A[i]){
                            ArrayList<Integer> tempAns = new ArrayList<>();
                            tempAns.add(localMinimaPtr);
                            tempAns.add(i);
                            ans.add(tempAns);
                        }
                        localMaximaPtr = n;

                        break;
                    }else{
                        if(A[i-1]<=A[i] && A[i+1]<A[i]){
                            localMaximaPtr = i;
                            findLocalMaxima = false;
                            ArrayList<Integer> tempAns = new ArrayList<>();
                            tempAns.add(localMinimaPtr);
                            tempAns.add(localMaximaPtr);
                            ans.add(tempAns);
                            break;
                        }
                    }

                }
            }
            if(!findLocalMaxima){
                //find local minima
                for(int i=localMaximaPtr+1; i<n; i++){
                    if(i==n-1){
                        localMaximaPtr = n;
                        break;
                    }else{
                        if(A[i-1]>=A[i] && A[i+1]>A[i]){
                            localMinimaPtr = i;
                            findLocalMaxima = true;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
