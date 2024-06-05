package LeetCodeProblems;

public class TappingRainWater {
    public static void main(String args[]){
        int arr[] = {7, 4, 0, 9};
        System.out.println(trappingWater(arr,arr.length));
    }
    static long trappingWater(int arr[], int n) {

        if(n<3){
            return 0L;
        }
        int i = 0;
        int j = n-1;
        int minH = 0;
        Long result =  tappingWater(arr, i, j, minH, 0L);
        return result;
    }

    public static long tappingWater(int arr[], int i, int j, int minH, Long netVolume){

        //   return condition
        if(i==j){
            return netVolume;
        }
        int min = Math.min(arr[i], arr[j]);
        int reqIdx = j-i-1;

        if(arr[i]<arr[j]){
            i++;
        }else{
            j--;
        }
        if(minH >= min){
            netVolume = netVolume - min;

        }else{
            netVolume = netVolume + 1L*reqIdx*(min -minH);
            minH = min;}

        return tappingWater(arr, i, j, minH, netVolume);

    }
}

