package org.example;

import java.util.*;

public class SortLevel {
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
}
