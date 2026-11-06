class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int n = arr.length;
        //increasing case
        while(i+1 < n && arr[i] < arr[i+1]){
            i++;
        }
        //false case
        if(i==0 || i == n-1){
            return false;
        }
        //decreasing case
        while(i+1 < n && arr[i] > arr[i+1]){
            i++;
        }
        return i == n-1;
    }
}