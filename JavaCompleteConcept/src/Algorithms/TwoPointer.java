package Algorithms;

import java.util.Arrays;

public class TwoPointer {
    public static void main(String args[]) {
        int arr[] = {2, 3, 5, 1, 7, 12, 27, 23};
        int target = 34;

        /** first lets sort the array */
        Arrays.sort(arr);

        /** now applying two pointer */
        int i = 0;
        int j = arr.length -1;
        while(i!=j){
            if(arr[i] + arr[j] == target){
                System.out.println(++i + " " + j);
                break;
            }
            if (arr[i] +arr[j]> target){
                j--;
            }
            if(arr[i] + arr[j]<target){
                i++;
            }
        }

        }
    }



