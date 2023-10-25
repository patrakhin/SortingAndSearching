package org.example;

import java.util.Objects;

public class BinarySearch {
    private int[] array;
    public int Left;
    public int Right;
    private int result;

    public BinarySearch(int[] sortedArray) {
        array = sortedArray;
        Left = 0;
        Right = array.length - 1;
        result = 0;
    }

    public void Step(int N) {

        int mid = (Left + Right) / 2;

        if (array[mid] == N) {
            result = 1;
            return;
        }

        if (N > array[mid]) {
            Left = mid + 1;
        }
        if (N < array[mid]) {
            Right = mid - 1;
        }

        if (Left == Right && array[Right] == N) {
            result = 1;
            return;
        }
        if (Left == Right && array[Right] != N || (Left != Right && Math.abs(Left - Right) == 1)) {
            result = -1;
        }

    }

    public int GetResult() {
        return result;
    }

}


