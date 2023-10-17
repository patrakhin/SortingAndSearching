package org.example;

import java.util.Arrays;

public class ksort_2 {
    public String[] items;

    public ksort_2() {
        items = new String[800];
    }

    public int index(String s) {
        if (!isValidFormat(s)){
            return -1;
        }
        return Integer.parseInt(s.substring(1));
    }

    public boolean add(String s) {
        if (!isValidFormat(s)) {
            return false;
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null || items[i].compareTo(s) > 0) {
                shiftItemsRight(i);
                items[i] = s;
                break;
            }
        }
        return true;
    }

    private void shiftItemsRight(int index) {

        for (int i = items.length - 1; i > index; i--) {
            items[i] = items[i - 1];
        }
    }

    public boolean isValidFormat(String s) {
        String pattern = "[a-h][0-9]{2}";
        return s.matches(pattern);
    }

    public static void main(String[] args) {
        ksort sorter = new ksort();

        // Примеры использования
        sorter.add("a00");
        sorter.add("a01");
        sorter.add("a99");
        sorter.add("b64");
        sorter.add("g99");

        System.out.println("Index of a00: " + sorter.index("a00")); // Должно вывести 0
        System.out.println("Index of a01: " + sorter.index("a01")); // Должно вывести 0
        System.out.println("Index of a01: " + sorter.index("a99"));
        System.out.println("Index of g99: " + sorter.index("g99")); // Должно вывести 2
        System.out.println("Index of b64: " + sorter.index("b64"));
        System.out.println("Index of d12: " + sorter.index("d12")); // Должно вывести -1 (не найдено)

        System.out.println("Adding a99: " + sorter.add("a99")); // Должно вернуть true
        System.out.println("Adding x88: " + sorter.add("x88")); // Должно вернуть false (некорректный формат)
        System.out.println("Adding f05: " + sorter.add("f05")); // Должно вернуть true

        System.out.println("Sorted items: " + Arrays.toString(sorter.items));
    }
}

