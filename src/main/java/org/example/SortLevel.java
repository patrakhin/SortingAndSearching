package org.example;

import java.util.*;

public class SortLevel {

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
}
