package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLevelForSolving_003 {
    public static ArrayList<Integer> KnuthSequence(int array_size){
        int h = 1;
        ArrayList<Integer> step = new ArrayList<>();
        while (h < array_size || h == 1){
            step.add(h);
            h = 3 * h + 1;
        }
        return step;
    }

    public static void main(String[] args) {

        int[] array = {1, 6, 5, 4, 3, 2, 7};
        int d = 15;
        System.out.println(KnuthSequence(d));
    }
}
