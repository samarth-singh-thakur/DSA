//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int c_sum = arr[0], s_ptr = 0;
        if(s!=0){
            for(int i=1; i<=n; i++){
                
                while(c_sum>s && s_ptr<=i -1){
                    c_sum = c_sum - arr[s_ptr];
                    s_ptr++;
                
                }
                if(c_sum==s){
                    ans.add(++s_ptr);
                    ans.add(i);
                    return ans;
                }
                if(i<n){
                    c_sum = c_sum+arr[i];
                }
                
            }     
        }

        ans.add(-1);
        return ans;
    }
}