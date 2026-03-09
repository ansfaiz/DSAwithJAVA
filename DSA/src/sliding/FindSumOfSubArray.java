package sliding;

import java.util.ArrayList;

public class FindSumOfSubArray {
    private ArrayList<Integer>  sum (int []arr,int k){
        ArrayList<Integer> res=new ArrayList<>();
        int sum=0;
        int n=arr.length;
        int start=0;
        for (int end=0;end<n;end++){
            if(end<k){
                sum+=arr[end];
            }else{
                res.add(sum);
                sum=sum-arr[start]+arr[end];
                start++;
            }
        }
        res.add(sum);
        return res;
    }
    public static void main(String[] args) {
        FindSumOfSubArray s=new FindSumOfSubArray();
        int []arr={2,8,-1,5,4,1,3,0};
        System.out.println(s.sum(arr,9));

    }

}
