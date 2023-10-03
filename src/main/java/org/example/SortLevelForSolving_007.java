package org.example;

import java.util.ArrayList;
import java.util.Arrays;


public class SortLevelForSolving_007 {

    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        int pivotIndex = ArrayChunk(Array, L, R);
        ArrayList<Integer> resultList = new ArrayList<>();

        if (pivotIndex == k) {
            resultList.add(pivotIndex);
            resultList.add(pivotIndex);
            return resultList;
        }
        if (pivotIndex < k) {
            resultList.add(pivotIndex + 1);
            resultList.add(R);
            return resultList;
        }

            resultList.add(L);
            resultList.add(pivotIndex - 1);
            return resultList;

    }

    public static int ArrayChunk(int[] M, int left, int right ) {
        int baseIndex = (right + left) / 2;
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
        int[] Array = {5, 1, 2, 4, 3};
        int k = 4; // Ищем -ю порядковую статистику

        ArrayList<Integer> result = KthOrderStatisticsStep(Array, 0, Array.length - 1, k);
        int newL = result.get(0);
        int newR = result.get(1);

        System.out.println("Новые границы L и R: " + newL + " " + newR);
    }
}
