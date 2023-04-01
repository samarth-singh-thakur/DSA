//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
  static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here
        int mc=0, mr=0;
        c=matrix[0].length-1;
        r=matrix.length-1;
        int cnt =(c+1)*(r+1)-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(cnt>=0){
            for(int i=mc; i<=c&&cnt-->=0; i++)
                ans.add(matrix[mr][i]);
            mr++;
            for(int i=mr; i<=r&&cnt-->=0; i++)
                ans.add(matrix[i][c]);
            c--;
            for(int i=c; i>=mc&&cnt-->=0;i--)
                ans.add(matrix[r][i]);
            r--;
            for(int i=r; i>=mr&&cnt-->=0;i--)
                ans.add(matrix[i][mc]);
            mc++;
        }
        return ans;


    }
}
