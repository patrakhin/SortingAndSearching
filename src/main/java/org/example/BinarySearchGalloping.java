package org.example;

public class BinarySearchGalloping {
    private int[] array;
    public int Left;
    public int Right;
    private int result;

    public BinarySearchGalloping(int[] sortedArray) {
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

    public boolean GallopingSearch(int[] array, int target) {
        int i = 1;
        int currentIndex = (int) (Math.pow(2, i) - 2);

        if (currentIndex < array.length && array[currentIndex] == target) {
            return true;
        }

        while (currentIndex < array.length - 1 && array[currentIndex] < target) {
            i++;
            currentIndex = (int) (Math.pow(2, i) - 2);
        }

        if (currentIndex >= array.length - 1) {
            currentIndex = array.length - 1;
        }

        if (array[currentIndex] == target) {
            return true;
        }

        int lowerBound = ((int) (Math.pow(2, (i - 1))) - 2) + 1;
        int upperBound = currentIndex;
        BinarySearchGalloping binarySearchGalloping = new BinarySearchGalloping(array);
        binarySearchGalloping.Left = lowerBound;
        binarySearchGalloping.Right = upperBound;
        while (binarySearchGalloping.Left <= binarySearchGalloping.Right) {
            binarySearchGalloping.Step(target);
            if (binarySearchGalloping.GetResult() == 1) {
                return true;
            }
        }
        return false;
    }
}
