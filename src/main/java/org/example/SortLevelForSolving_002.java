package org.example;

import java.util.Arrays;

public class SortLevelForSolving_002 {
    public static int[] InsertionSortStep (int[] array, int step, int i) {
        int different = array.length - i;
        if ((step < 1 || step > (different - 1)) || (i < 0 || i >= array.length - i)) {
            return array;
        }
        int buffer;
        for (int j = 0; j < 1; j++){
            buffer = array[i];
            array[i] = array[i + step];
            array[i + step] = buffer;
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {1,6,5,4,3,2,7};
        int step = 3;
        int i =1;
        System.out.println(Arrays.toString(InsertionSortStep(array,step, i)));
    }

}
