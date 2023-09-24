package org.example;

import java.util.*;

public class SortLevel {
    public static void QuickSort(int[] array, int left, int right) {
        if (left != right) {
            int pivotIndex = ArrayChunk(array, left, right);
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
}
