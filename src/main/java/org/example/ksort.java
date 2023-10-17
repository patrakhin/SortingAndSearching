package org.example;

import java.util.*;

public class ksort {
    public String[] items;

    public ksort() {
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
}

