package leetcode;

public class median {
	public static void main (String[]args) {
		int []n = {1,2};
		int []m = {3,4};
		System.out.print(findMedianSortedArrays(n, m));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lens1 = nums1.length;
        int lens2 = nums2.length;
        int total = lens1 + lens2;
        int s1=0,s2=0;
        float r = 0,l = 0;
        int n = 0;
        boolean f = true;
        if (total%2 != 0)
            n = total/2;
        else{
            n = (total-1)/2+1;
            f = false;
        }
        for (int i = 0; i <= n;i++){
            if (s1 < lens1 && s2 < lens2){
                if (nums1[s1] <= nums2[s2]){
                    r = l;
                    l = nums1[s1];
                    s1 +=1;
                } 
                else {
                    r = l;
                    l = nums2[s2];
                    s2 +=1;
                }
            }
            else if (s2 <lens2){
                r = l;
                l = nums2[s2];
                s2 +=1;
            }
            else {
                r = l;
                l = nums1[s1];
                s1 +=1;
            }
        }
        if (f)
            return l;
        else 
            return (l+r)/2;
    }
}
