package org.example;

import java.util.Arrays;

public class SortLevel {
    public static int[] InsertionSortStep (int[] array, int step, int i) {
        int different = array.length - i;
        int sizeBuffArray = 0;
        if ((different) % step == 0){
            sizeBuffArray = (different) / step;
        }else{
            sizeBuffArray = (different) / step + 1;
        }
        int[] buffArray = new int[sizeBuffArray];
        int[] indexArray = new int[sizeBuffArray];
        for (int j = i, k = 0; j < array.length; j +=step, k++){
            buffArray[k] = array[j];
            indexArray[k] = j;
        }
        Arrays.sort(buffArray);
        for (int x = 0; x < buffArray.length; x++){
            int insertIndex = indexArray[x];
            int numberOfArray = buffArray[x];
            array[insertIndex] = numberOfArray;
        }
        return array;
    }
}
