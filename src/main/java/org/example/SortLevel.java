package org.example;

import java.util.Arrays;

public class SortLevel {
    public static int[] InsertionSortStep (int[] array, int step, int i) {
        int different = array.length - i;
        if ((step < 1 || step > (different - 1)) || (i < 0 || i >= array.length - i)) {
            return array;
        }
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
}
