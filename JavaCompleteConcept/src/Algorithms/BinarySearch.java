package Algorithms;

public class BinarySearch {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 5;
        int i = 0;
        int j = 7;
        System.out.println(biSearch(i,j,arr,target));

    }

    private static int biSearch(int i, int j, int[] arr, int target) {

        int mean = i + (i-j)/2;  //int mean = (i + j)/2;

        if(arr[mean] == target){
            return mean;
        }
        if(arr[mean]<target){
            i = mean + 1;
        }
        if(arr[mean]>target){
            j = mean -1;
        }
       return biSearch(i,j,arr,target);
    }
}
