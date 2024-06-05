package Algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]){
        int[] arr = {2,1,5,8,4,5,6,15,10,9};
        int left = 0;
        int right = arr.length-1;
        merge_Sort(arr, left, right);
        Arrays.stream(arr).forEach(value -> System.out.println(value));

    }

    private static void merge_Sort(int[] arr, int left, int right) {

        int mean = left + (right - left)/2;
        divission(left,mean, arr );
        divission(mean+1, right, arr);
        merge(left, mean, right, arr);
    }

    private static void merge(int left, int mean, int right, int[] arr) {

      int leftArrLength = mean - left + 1;
        int rightArrLength = right - mean;
        int brr[] = new int[leftArrLength + rightArrLength];
        int i = left;
        int j = mean + 1;
        int brrIdx = 0;


        while (i <= mean && j <= right) {

            if (i <= mean && arr[i] <= arr[j]) {
                brr[brrIdx] = arr[i];
                brrIdx++;
                i++;
            } else if (j <= right ) {
                brr[brrIdx] = arr[j];
                brrIdx++;
                j++;
            }
        }
        while(brrIdx<brr.length){
            if(i <= mean){
                brr[brrIdx] = arr[i];
                brrIdx++;
                i++;
            }else{
                brr[brrIdx] = arr[j];
                brrIdx++;
                j++;
            }
        }
        for (int ix = 0; ix < brr.length; ix++) {
            arr[left] = brr[ix];
            left++;
        }

    }

    private static void divission(int left, int right, int[] arr) {

        if(left==right){
            return;
        }
        merge_Sort(arr,left,right);
    }
}


/**Few tips gor better coding style
 * 1.Renamed merge_Sort to mergeSort to follow Java naming conventions.
 * 2.Used meaningful variable names like mid instead of mean for the midpoint.
 * 3.Changed the condition in mergeSort to left < right for the base case check.
 * 4.Used tempIdx instead of brrIdx for better readability.
 * 5.Simplified the merging logic in the merge method by removing unnecessary conditions.
 * 6.Used System.arraycopy to copy elements from the temporary array back to the original array for better performance
 * */


/** here is better coding style
 * package Algorithms;
 *
 * import java.util.Arrays;
 *
 * public class MergeSort {
 *
 *     public static void main(String args[]) {
 *         int[] arr = {2, 1, 5, 8, 4, 5, 6, 15, 10, 9};
 *         int left = 0;
 *         int right = arr.length - 1;
 *         mergeSort(arr, left, right);
 *         Arrays.stream(arr).forEach(System.out::println);
 *
 *     }
 *
 *     private static void mergeSort(int[] arr, int left, int right) {
 *
 *         if (left < right) {
 *             int mid = left + (right - left) / 2;
 *             mergeSort(arr, left, mid);
 *             mergeSort(arr, mid + 1, right);
 *             merge(left, mid, right, arr);
 *         }
 *     }
 *
 *     private static void merge(int left, int mid, int right, int[] arr) {
 *
 *         int leftArrLength = mid - left + 1;
 *         int rightArrLength = right - mid;
 *         int[] temp = new int[leftArrLength + rightArrLength];
 *         int i = left;
 *         int j = mid + 1;
 *         int tempIdx = 0;
 *
 *         while (i <= mid && j <= right) {
 *             if (arr[i] <= arr[j]) {
 *                 temp[tempIdx++] = arr[i++];
 *             } else {
 *                 temp[tempIdx++] = arr[j++];
 *             }
 *         }
 *
 *         while (i <= mid) {
 *             temp[tempIdx++] = arr[i++];
 *         }
 *
 *         while (j <= right) {
 *             temp[tempIdx++] = arr[j++];
 *         }
 *
 *         System.arraycopy(temp, 0, arr, left, temp.length);
 *     }
 * }*/
