package org.example;

import java.util.ArrayList;


public class SortLevelForSolving_008 {

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> arr)  {
        int size = arr.size();
        if (size <= 1) {
            return arr; // Если массив уже отсортирован или содержит 1 элемент, возвращаем его
        }

        // Разделяем массив на два подмассива
        int middle = size / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(middle, size));

        // Рекурсивно сортируем оба подмассива
        left = MergeSort(left);
        right = MergeSort(right);

        // Объединяем отсортированные подмассивы
        return merge(left, right);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIdx = 0;
        int rightIdx = 0;

        // Сравниваем элементы из обоих подмассивов и добавляем минимальный в результирующий массив
        while (leftIdx < left.size() && rightIdx < right.size()) {
            if (left.get(leftIdx) < right.get(rightIdx)) {
                result.add(left.get(leftIdx));
                leftIdx++;
            } else {
                result.add(right.get(rightIdx));
                rightIdx++;
            }
        }

        // Добавляем оставшиеся элементы из левого подмассива (если есть)
        while (leftIdx < left.size()) {
            result.add(left.get(leftIdx));
            leftIdx++;
        }

        // Добавляем оставшиеся элементы из правого подмассива (если есть)
        while (rightIdx < right.size()) {
            result.add(right.get(rightIdx));
            rightIdx++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(11);
        arr.add(13);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        System.out.println("Исходный массив: " + arr);
        ArrayList<Integer> sortedArr = MergeSort(arr);
        System.out.println("Отсортированный массив: " + sortedArr);
    }
}

