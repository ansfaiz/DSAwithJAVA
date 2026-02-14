package binarySearch;

public class P268 {
        public int missingNumber(int[] nums) {
       /*  total no should be n+1 so we to find 1 missing no.
         thats we need a basic math formula where find  totalSum in range of 0 to n
         and find sum of given array nums[] then sum is subtract from totalSum we find missing value */
            int n=nums.length;
            int totalSum= n*(n+1)/2;
            int sum=0;
            for(int x:nums){
                sum+=x;
            }
            return  totalSum-sum;
        }
    public static void main(String[] args) {
            int[] num={9,6,4,2,3,5,7,0,1};
            P268 p=new P268();
            System.out.println(" missing no of given array is : "+p.missingNumber(num));

    }

}
