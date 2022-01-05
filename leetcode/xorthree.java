package leetcode;

public class xorthree {
	public static void main(String[]args) {
		int [] arr = {2,3,1,6,7};
		System.out.print(countTriplets(arr));
	}
	public static int countTriplets(int[] arr) {
        int a = 0, b = 0;
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len-1; i++){
            
            for (int j = i+1; j < len; j++){
                a = 0;
                for(int x = i; x < j; x++){
                    a = a^arr[x];
                }
                
                for (int k = j; k < len; k++){
                    b = 0;
                    for (int y = j; y <= k; y++){
                        b = b^arr[y];
                    }
                    if (a == b)
                        count ++;
                }
            }
        }
        return count;
    }
}
