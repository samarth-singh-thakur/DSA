//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class SecondPair {
    long first, second;

    public SecondPair(long first, long second) {
        this.first = first;
        this.second = second;
    }

    long getFirst() {
        return this.first;
    }

    long getSecond() {
        return this.second;
    }
}

class Solution {
    public pair[] allPairs(long A[], long B[], long N, long M, long X) {
        // Your code goes here
        HashSet<Long> set = new HashSet<>();
        ArrayList<SecondPair> ans = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            set.add(B[i]);
        }

        for (int i = 0; i < N; i++) {
            if (set.contains(X - A[i])) {
                SecondPair temp = new SecondPair(A[i], X - A[i]);
                ans.add(temp);
            } else {
                continue;
            }
        }
        Collections.sort(ans, new Comparator<SecondPair>() {
            public int compare(SecondPair left, SecondPair right) {
                return (int) (left.getFirst() - right.getFirst());
            }
        });

        pair[] p = new pair[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            pair temp = new pair(ans.get(i).getFirst(), ans.get(i).getSecond());
            p[i] = temp;
        }
        return p;
    }
}
