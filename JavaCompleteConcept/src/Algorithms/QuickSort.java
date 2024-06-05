package Algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]){
        int[] arr = {2,4,6,3};
        int len = arr.length;
        int i = 0;
        int j = arr.length -1;
        quick(i,j,arr);
        Arrays.stream(arr).forEach(val-> System.out.println(val));
    }
   public static void swaper(int a, int b, int arr[]){
       int temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
   }
    public static void quick(int i, int j, int[] arr){
        int left = i;
        int right = j;
        if(i>j){
            return;
        }
        int pivot = i;
        while(i<j){

            while(i< arr.length && arr[i]<=arr[pivot] && i <= j){
                i++;
            }

            while(arr[j]>=arr[pivot] && i <= j ){
                j--;
            }
            if(i>j){
                swaper(j, pivot, arr);
                pivot = j;
                break;
            }
            swaper(i,j, arr);

        }
        if(pivot - left>1 ){
        quick(left, pivot-1,arr);}

        if(right - pivot  > 1 ){
        quick(pivot+1,right,arr);}

    }
}
