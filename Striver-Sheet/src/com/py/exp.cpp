#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int sumNMinimum(const vector<int>& arr1, const vector<int>& arr2, int n) {
    vector<int> merged(arr1);
    merged.insert(merged.end(), arr2.begin(), arr2.end()); // Merge the two arrays
    
    sort(merged.begin(), merged.end()); // Sort the merged array in ascending order
    
    int sum = 0;
    for (int i = 0; i < n; ++i) {
        sum += merged[i]; // Sum the first n elements
    }
    
    return sum;
}

int main() {
    vector<int> array1 = {1,2,3};
    vector<int> array2 = {2,3,1};

    int n = 3; // Select and sum the 3 minimum elements
    
    int result = sumNMinimum(array1, array2, n);
    
    cout << "The sum of the " << n << " minimum elements is: " << result << endl;
    
    return 0;
}


void printFactorsInArray(int arr[],int n, int x) {
    vector<int> factors;
    
    for (int i=0;i<n;i++) {
        if (x % arr[i] == 0) {
            std::cout<<arr[i]<<" ";
            // factors.push_back(num);
        }
    }
}