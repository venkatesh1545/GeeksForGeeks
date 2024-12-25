#User function Template for python3
class Solution:
    def setMatrixZeroes(self, mat):
        row_info = [False]*len(mat)
        column_info = [False]*len(mat[0])
        
        for ind, row in enumerate(mat):
            if 0 in row:
                row_info[ind] = True
                
        for col_ind in range(len(mat[0])):
            is_zero_present = False
            for row_ind in range(len(mat)):
                is_zero_present = is_zero_present or mat[row_ind][col_ind] == 0
            column_info[col_ind] = is_zero_present
            
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if row_info[i] or column_info[j]:
                    mat[i][j] = 0


#{ 
 # Driver Code Starts
import sys

# Position this line where user code will be pasted.
if __name__ == "__main__":
    input = sys.stdin.read
    data = input().split()

    idx = 0
    t = int(data[idx])
    idx += 1
    results = []

    for _ in range(t):
        n, m = map(int, data[idx:idx + 2])
        idx += 2
        arr = []
        for i in range(n):
            arr.append(list(map(int, data[idx:idx + m])))
            idx += m

        sol = Solution()
        sol.setMatrixZeroes(arr)

        for row in arr:
            results.append(" ".join(map(str, row)))

        results.append("~")

    sys.stdout.write("\n".join(results) + "\n")

# } Driver Code Ends