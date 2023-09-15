package org.example;

import java.util.*;

public class SortLevel {

    public static ArrayList<Integer> KnuthSequence(int array_size){
        int h = 1;
        ArrayList<Integer> step = new ArrayList<>();
        while (h < array_size || h == 1){
            step.add(h);
            h = 3 * h + 1;
        }
        return step;
    }
}
