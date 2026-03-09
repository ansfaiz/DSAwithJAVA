package sliding;

public class MaxSum {
    private int maxsumofArray(int[] arr,int k){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        maxSum=sum;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];
            sum -= arr[i-k];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
