//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        // code here
        int l = 0; int r = 0;
        int n = arr.size();
        int sum = 0;

        while(l<n and r<n)
        {sum += arr[r];
          if(sum == target)
          {
            
            return {l+1,r+1};
          }
          while(sum>target)
          {
              sum -= arr[l];
              l++;
          }
           if(sum == target)
          {
              return {l+1,r+1};
          }
          r++;
           
            
        }
        return {-1};
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        int d;
        string input;

        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        cin >> d;
        cin.ignore();

        Solution ob;
        vector<int> result = ob.subarraySum(arr, d);
        for (int i : result) {
            cout << i << " ";
        }
        cout << "\n~\n";
    }
    return 0;
}

// } Driver Code Ends