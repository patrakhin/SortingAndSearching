package org.example;

import java.util.Arrays;

public class SortLevelForSolving_002 {
    public static int[] InsertionSortStep (int[] array, int step, int i) {
        int different = array.length - i;
        int sizeBuffArray = 0;
        for (int a = 0; a < 1; a ++) {
            if ((different- a) % step == 0){
                sizeBuffArray = (different - a) / step;
            }else{
                sizeBuffArray = (different - a) / step + 1;
            }
            int[] buffArray = new int[sizeBuffArray];
            int[] indexArray = new int[sizeBuffArray];
            for (int j = a, k = 0; j < different; j +=step, k++){
                buffArray[k] = array[j];
                indexArray[k] = j;
            }
            Arrays.sort(buffArray);
            for (int x = 0; x < buffArray.length; x++){
                int insertIndex = indexArray[x];
                int numberOfArray = buffArray[x];
                array[insertIndex] = numberOfArray;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {7,6,5,4,3,2,1};
        int step = 3;
        int i =0;
        System.out.println(Arrays.toString(InsertionSortStep(array,step, i)));
    }

}
