package org.example;

public class BinarySearch {
    public int[] array;
    public int Left;
    public int Right;
    public int result;

    public BinarySearch(int[] sortedArray) {
        array = sortedArray;
        Left = 0;
        Right = array.length - 1;
        result = 0;
    }

    public void Step(int N) {

        int mid = (Left + Right) / 2;
        if (Left == Right || (Left != Right && (Math.abs(Left - Right) == 1))) {
            result = 1;
            return;
        }

        if (array[mid] == N) {
            result = 1;
            return;
        }
        if (N > array[mid]) {
            Left = mid + 1;
        }
        if (N < array[mid]){
            Right = mid - 1;
        }

    }

    public int GetResult() {
        return result;
    }

}


