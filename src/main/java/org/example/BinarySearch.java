package org.example;

import java.util.Objects;

public class BinarySearch {
    private int[] array;
    public int Left;
    public int Right;
    private String result;

    public BinarySearch(int[] sortedArray) {
        array = sortedArray;
        Left = 0;
        Right = array.length - 1;
        result = "0";
    }

    public void Step(int N) {

        if (!Objects.equals(result, "0")) return;

        int mid = (Left + Right) / 2;

        if (array[mid] == N) {
            Left = 0;
            Right = array.length - 1;
            result = "+1";
            return;
        }

        if (N > array[mid]) {
            Left = mid + 1;
        }
        if (N < array[mid]) {
            Right = mid - 1;
        }

        if (Left == Right || (Left != Right && Math.abs(Left - Right) == 1)) {
            /*Left = 0;
            Right = array.length - 1;*/
            result = "-1";
        }

    }

    public int GetResult() {
        String tempResult = result;
        if (!Objects.equals(result, "0")) {
            Left = 0;
            Right = array.length - 1;
            result = "0";
        }
        return Integer.parseInt(tempResult);
    }
}


