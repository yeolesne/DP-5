/*
 * #62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:
Refer leetcode for image	

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Example 3:

Input: m = 7, n = 3
Output: 28

Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1. 1 <= m, n <= 100
2. It's guaranteed that the answer will be less than or equal to 2 * 109.

 */


/*
 * Time Complexity: O (m * n) -> Traverse through each cell of a 2D array
 * 
 * Space Complexity: O (m * n) -> Creating a DP array with m rows and n columns	
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.DP5;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        
        // #1. Base condition
        if(m == 0 || n == 0){
            return 0;
        }
        
        // #2. Create a DP 2D array with m rows and n columns
        int[][] dp = new int[m][n];
        
        // #3. Fill the first row and first column with 1's as number of ways to get to each cell in that row and column is 1 only
        
        // Fill first column with 1's
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        
        // Fill first row with 1's
        for(int j = 1; j < n; j++){
            dp[0][j] = 1;
        }
        
        // #4. Traverse through rest of the cells except of first row and first column to find number of ways to get to that particular cell
        for(int l = 1; l < m; l++){
            for(int k = 1; k < n; k++){
                dp[l][k] = dp[l-1][k] + dp[l][k-1]; // We can get to a particular cell either from its up or left, so add up the number of ways 
            }
        }
        
        return dp[m-1][n-1]; // return the unique paths/total number of ways to reach finish point which is at the last cell
        
    }

}
