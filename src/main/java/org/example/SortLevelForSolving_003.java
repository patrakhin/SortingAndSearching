package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLevelForSolving_003 {
    public static ArrayList<Integer> KnuthSequence(int array_size){
        ArrayList<Integer> step = new ArrayList<>();
        int h = 1;
        if (array_size == 1){
            step.add(0, 1);
            return step;
        }
        while (h < array_size){
            step.add(0, h);
            h = 3 * h + 1;
        }
        return step;
    }

    public static void main(String[] args) {

        int[] array = {1, 6, 5, 4, 3, 2, 7};
        int d = -1;
        System.out.println(KnuthSequence(d));
    }
}
