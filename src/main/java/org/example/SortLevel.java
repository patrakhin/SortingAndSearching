package org.example;

import java.util.*;

public class SortLevel {
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arr)  {
        int size = arr.size();
        if (size <= 1) {
            return arr;
        }

        int middle = size / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(middle, size));

        left = MergeSort(left);
        right = MergeSort(right);

        return merge(left, right);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIdx = 0;
        int rightIdx = 0;

        while (leftIdx < left.size() && rightIdx < right.size()) {
            if (left.get(leftIdx) < right.get(rightIdx)) {
                result.add(left.get(leftIdx));
                leftIdx++;
            } else {
                result.add(right.get(rightIdx));
                rightIdx++;
            }
        }

        while (leftIdx < left.size()) {
            result.add(left.get(leftIdx));
            leftIdx++;
        }

        while (rightIdx < right.size()) {
            result.add(right.get(rightIdx));
            rightIdx++;
        }

        return result;
    }
}
