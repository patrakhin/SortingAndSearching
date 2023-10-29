package org.example;

import java.util.*;

public class SortLevel {
    private static class BinarySearch {
        private int[] array;
        public int Left;
        public int Right;
        private int result;

        public BinarySearch(int[] sortedArray, int left, int right) {
            array = sortedArray;
            Left = left;
            Right = right;
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
            } else {
                Right = mid - 1;
            }
        }

        public int GetResult() {
            return result;
        }
    }

    public static boolean GallopingSearch(int[] array, int target) {
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

        int lowerBound = ((int) (Math.pow(2, i - 1)) - 2) + 1;
        int upperBound = currentIndex;
        BinarySearch binarySearch = new BinarySearch(array,lowerBound,upperBound);
        while (binarySearch.Left <= binarySearch.Right) {
            binarySearch.Step(target);
            if (binarySearch.GetResult() == 1) {
                return true;
            }
        }
        return false;
    }
}
