package com.whs.javacoding.twentypatterns;

import java.util.*;

class Element {
    int value, arrayIndex, elementIndex;
    Element(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class KWayMerge {
    public static List<Integer> merge(int[][] arrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Element(arrays[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
                minHeap.add(new Element(
                        arrays[current.arrayIndex][current.elementIndex + 1],
                        current.arrayIndex,
                        current.elementIndex + 1
                ));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 5},
            {1, 3, 4},
            {2, 6}
        };
        System.out.println(merge(arrays)); // Output: [1, 1, 2, 3, 4, 4, 5, 6]
    }
}
