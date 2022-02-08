package utils;

import 算法.排序.插入排序法.InsertionSort;
import 算法.排序.选择排序法.SelectionSort;

public class SortingHelper {
    private SortingHelper(){};

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for(int i = 1; i < arr.length; i ++) {
            if(arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if(sortName.equals("SelectionSort1")) {
//            SelectionSort.sort1(arr);
        } else if(sortName.equals("SelectionSort2")) {
            SelectionSort.sort2(arr);
        } else if(sortName.equals("SelectionSort3")) {
            SelectionSort.sort3(arr);
        } else if(sortName.equals("InsertionSort1")) {
            InsertionSort.sort1(arr);
        } else if(sortName.equals("InsertionSort2")) {
            InsertionSort.sort2(arr);
        } else if(sortName.equals("InsertionSort3")) {
            InsertionSort.sort3(arr);
        }
        long endTime = System.nanoTime();
        double spend = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortName, arr.length, spend));
    };

}
