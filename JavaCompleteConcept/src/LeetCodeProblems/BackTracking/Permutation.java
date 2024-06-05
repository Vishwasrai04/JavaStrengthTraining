package LeetCodeProblems.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String args[]){
        System.out.println(new Permutation().permute(new int[]{4,1,2}));
    }
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length == 1) {
//            List<Integer> singleList = new ArrayList<>();
//            singleList.add(nums[0]);
//            res.add(singleList);
//            return res;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int n = nums[i];
//            int[] remainingNums = new int[nums.length - 1];
//            int index = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    remainingNums[index] = nums[j];
//                    index++;
//                }
//            }
//            List<List<Integer>> perms = permute(remainingNums);
//            for (List<Integer> p : perms) {
//                p.add(n);
//            }
//
//            res.addAll(perms);
//        }
//
//        return res;
//    }



        public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> singleList = new ArrayList<>();
            singleList.add(nums[0]);
            res.add(singleList);
            return res;
        }
        permut(0,nums,res );
//            System.out.println(res);
        return res;
    }

    public static void permut(int index, int[] nums , List<List<Integer>>List){

        if (index == nums.length) {
            List<Integer> list1 = new ArrayList<>();
            for (int x : nums) {
                list1.add(x);
            }
            List.add(list1);
            System.out.println(list1);
            return;
        }

        for(int i = index; i<nums.length; i++){

            swap(index,i, nums);
            permut(index +1,nums,List);
            swap(index,i, nums);
        }


    }

    private static void swap(int index, int pointer, int[] nums) {
        int temp = nums[index];
        nums[index] = nums[pointer];
        nums[pointer] = temp;

    }
}
