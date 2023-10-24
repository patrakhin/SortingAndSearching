package org.example;

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
        if (Left > Right || result != 0) return;

        int mid = (Left + Right) / 2;

        if (array[mid] == N) {
            result = 1;
            return;
        } else if (N > array[mid]) {
            Left = mid + 1;
        } else {
            Right = mid - 1;
        }

        if (Left == Right || Math.abs(Left - Right) == 1) {
            result = 0;
        }
    }

    public int GetResult() {
        int tempResult = result;
        result = 0;
        return tempResult;
    }

}


