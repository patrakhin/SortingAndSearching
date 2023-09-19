package org.example;

import java.util.*;

public class SortLevel {
    public static int ArrayChunk( int[] M ){
        int baseIndex = M.length/2;
        int N =  M[baseIndex]; //0
        int i1 = 0;
        int i2 = M.length - 1; //1
        while (true) {
            while (M[i1] < N) { //2
                i1++;
            }
            while (M[i2] > N) { //3
                i2--;
            }
            if (i1 == i2 - 1 && M[i1] > M[i2]) { //4
                int buffer = 0;
                buffer = M[i1];
                M[i1] = M[i2];
                M[i2] = buffer;
            }
            if (i1 == i2 || (i1 == i2 - 1 && M[i1] < M[i2])) { //5
                return baseIndex;
            }
            int buffer2 = 0;
            buffer2 = M[i1];
            M[i1] = M[i2];
            M[i2] = buffer2;
            if (i1 == baseIndex) {
                baseIndex = i2;
            } else if (i2 == baseIndex) {
                baseIndex = i1;
            }
        }
    }
}
