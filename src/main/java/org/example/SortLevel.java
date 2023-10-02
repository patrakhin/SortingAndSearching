package org.example;

import java.util.*;

public class SortLevel {
    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        int pivotIndex = partition(Array, L, R);

        if (pivotIndex == k) {
            result.add(L);
            result.add(R);
            return result;
        } else if (pivotIndex < k) {
            return KthOrderStatisticsStep(Array, pivotIndex + 1, R, k);
        } else {
            return KthOrderStatisticsStep(Array, L, pivotIndex - 1, k);
        }
    }

    public static int partition(int[] Array, int L, int R) {
        int pivot = Array[(L + R) / 2];
        while (L <= R) {
            while (Array[L] < pivot) {
                L++;
            }
            while (Array[R] > pivot) {
                R--;
            }
            if (L <= R) {
                // Swap Array[L] and Array[R]
                int temp = Array[L];
                Array[L] = Array[R];
                Array[R] = temp;
                L++;
                R--;
            }
        }
        return L - 1;
    }
}
