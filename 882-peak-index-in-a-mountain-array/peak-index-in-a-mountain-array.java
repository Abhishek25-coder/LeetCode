class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int ans = -1;

        while(s<=e){
             int mid = s + (e-s)/2;
            if(arr[mid]<arr[mid+1]){
                //we are in ascending order
                //in left part
                //answer is in right part
                //move to right
                s = mid+1;
            }
             else{
                //(arr[mid]>=arr[mid+1])
                //we are in descending order
                // it could be answer also
                ans = mid;
                //if there is any bigger answer it will be in left so move to left
                e = mid-1;
             }
        }
        return ans;
    }
}