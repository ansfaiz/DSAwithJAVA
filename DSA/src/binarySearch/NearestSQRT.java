package binarySearch;

import java.util.Scanner;

public class NearestSQRT {
    public int sqrt(int x) {
        if (x < 2) return 1;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return right;

    }
    public static void main(String[] args) {
        NearestSQRT ns=new NearestSQRT();
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println(ns.sqrt(num));
    }

}
