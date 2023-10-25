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

        int mid = (Left + Right) / 2;

        if (array[mid] == N) {
            Left = 0;
            Right = array.length - 1;
            result = 1;
            return;
        }

        if (N > array[mid]) {
            Left = mid + 1;
        }
        if (N < array[mid]){
            Right = mid - 1;
        }

        if (Left == Right || (Left != Right && Math.abs(Left - Right) == 1)) {
            Left = 0;
            Right = array.length - 1;
            result = -1;
        }

    }

    public int GetResult() {
        int temp = result;
        result = 0;
        return temp;
    }

    public static class Main {
        public static void main(String[] args) {
            int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
            BinarySearch searcher = new BinarySearch(sortedArray);

            searcher.Step(9);
            System.out.println(searcher.GetResult()); // Выведет "1" (элемент найден)

            searcher.Step(13);
            System.out.println(searcher.GetResult()); // Выведет "0"

            searcher.Step(8);
            System.out.println(searcher.GetResult()); // Выведет "0"
        }
    }


}


