package org.example;

public class SortLevel_001 {
    public static int[] SelectionSortStep(int[] array, int i)
    {
        int number = array[i];
        int index = 0;
        int buff = 0;
        int min = array[i+1];
        if (i == array.length-1){
            return array;
        }
        if (i == array.length - 2 && number > min){
            buff = number;
            array[i] = min;
            array[array.length-1] = buff;
            return array;
        }
        for (int j = i +1; j < array.length; j++){
            if (min >array[j]){
                min = array[j];
                index = j;
            }
        }
        if (number > min){
            buff = number;
            array[i] = min;
            array[index] = buff;
        }
        return array ;
    }

    public static boolean BubbleSortStep( int[] array ){

        int changeBox = 0;
        boolean isChangeDone = true;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i+1]){
                changeBox = array[i];
                array[i] = array[i+1];
                array[i+1] = changeBox;
                isChangeDone = false;
            }
        }
        return isChangeDone;
    }
}
