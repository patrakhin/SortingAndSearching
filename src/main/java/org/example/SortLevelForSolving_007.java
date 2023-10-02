package org.example;

import java.util.ArrayList;
import java.util.Arrays;


public class SortLevelForSolving_007 {

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

    public static void main(String[] args) {
        int[] Array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 4; // Ищем 4-ю порядковую статистику

        ArrayList<Integer> result = KthOrderStatisticsStep(Array, 0, Array.length - 1, k);
        int newL = result.get(0);
        int newR = result.get(1);

        System.out.println("Новые границы L и R: " + newL + " " + newR);
    }
}
