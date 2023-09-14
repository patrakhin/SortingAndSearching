package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLevelForSolving_003 {
    public static int[] ShellSort (int[] array) {
        List<Integer> sequenceSort = KnuthSequence(array.length);
        for (int stepIndex = 0; stepIndex < sequenceSort.size(); stepIndex++) {
            int step = sequenceSort.get(stepIndex);
            for (int i = 0; i < step; i++) {
                InsertionSortStep(array, step, i);
            }
        }
        return array;
    }

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

    public static List<Integer> KnuthSequence(int array_size){
        int h = 1;
        List<Integer> sequence = new ArrayList<>();
        while (h < array_size){
            sequence.add(h);
            h = 3 * h + 1;
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {

        int[] array = {1, 6, 5, 4, 3, 2, 7};
        System.out.println(Arrays.toString(ShellSort(array)));
    }
}
