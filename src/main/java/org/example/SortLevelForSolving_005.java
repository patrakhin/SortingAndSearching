package org.example;

import java.util.Arrays;
import java.util.Random;

public class SortLevelForSolving_005 {
    private static void QuickSort(int[] array, int left, int right) {
        if (left != right) {
            int pivotIndex = ArrayChunk(array, left, right);//partition(array, left, right);
            QuickSort(array, left, pivotIndex - 1);
            QuickSort(array, pivotIndex + 1, right);
        }
    }

    public static int ArrayChunk(int[] M, int left, int right ) {
        int baseIndex = left + (right - left) / 2;
        int N = M[baseIndex]; //0
        int i1 = left;
        int i2 = right; //1
        while (true) {
            while (M[i1] < N) { //2
                i1++;
            }
            while (M[i2] > N) { //3
                i2--;
            }
            if (i1 == i2 - 1 && M[i1] > M[i2]) { //4
                int buffer = 0;
                buffer = M[i1];
                M[i1] = M[i2];
                M[i2] = buffer;
                ArrayChunk(M, left, right);
                //0
            }
            if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) { //5
                return baseIndex;
            }
            if (i1 == baseIndex) {
                baseIndex = i2;
            } else if (i2 == baseIndex) {
                baseIndex = i1;
            }
            int buffer2 = 0;
            buffer2 = M[i1];
            M[i1] = M[i2];
            M[i2] = buffer2;
        }
    }

    public static void main(String[] args) {
        //int[] array1 = {7,5,6,4,3,1,2}; //index 3 [2, 1, 3, 4, 6, 5, 7]
        //int[] array = {9};
        int[] array = {6,5,7}; //index 1
        //int[] array = {3,1,2};
        QuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}

