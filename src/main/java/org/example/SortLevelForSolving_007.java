package org.example;

import java.util.ArrayList;
import java.util.Arrays;


public class SortLevelForSolving_007 {

    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k ){
        ArrayList<Integer> resultList = new ArrayList<>();
        int N = (R + L) / 2;
        if (N == k){
            resultList.add(0,R);
            resultList.add(0, L);
            return resultList;
        }
        if (N < k){
            L = N + 1;
            resultList.add(0,R);
            resultList.add(0, L);
            return resultList;
        }
        R = N - 1;
        resultList.add(0,R);
        resultList.add(0, L);
        return resultList;
    }

    public static void main(String[] args) {
        int[] array = {7,5,6,4,3,1,2}; //index 3 [2, 1, 3, 4, 6, 5, 7]
        int L = 0;
        int R = 6;
        int k = 2;
        //int[] array = {9};
        //int[] array = {6,5,7}; //index 1
        //int[] array = {3,1,2};
        //QuickSort(array, 0, array.length - 1);
        System.out.println((KthOrderStatisticsStep(array, L, R, k)));
    }
}
