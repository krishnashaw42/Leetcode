class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        
        int p1 = 0; 
        int p2 =0;
        int i = 0;  
        
        
        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                arr[i] = nums1[p1];
                p1++;
            } else {
                arr[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        
        
        while (p1 < m) {
            arr[i] = nums1[p1];
            p1++;
            i++;
        }
        
        
        while (p2 < n) {
            arr[i] = nums2[p2];
            p2++;
            i++;
        }
        
        
        int totalLength = arr.length;
        if (totalLength % 2 == 0) {
            return (arr[totalLength / 2 - 1] + arr[totalLength / 2]) / 2.0;
        } else {
            return arr[totalLength / 2];
        }
    }
}