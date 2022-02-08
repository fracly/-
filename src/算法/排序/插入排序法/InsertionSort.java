package 算法.排序.插入排序法;

import utils.ArrayGenerator;
import utils.SortingHelper;

public class InsertionSort {
    private InsertionSort(){}

    // 最原始的版本
    public static <E extends Comparable<E>> void sort1(E[] data) {
        // [0, i) 之间的序列是有序的，[i, n)之间是无序的
        for(int i = 1; i < data.length; i ++) { // 一个元素本身永远是有序的，所以可以从i=1开始
            // 每一次循环都是保证i加入后，上面的循环不变体能保持成立
            for(int j = i; j > 0 && (data[j].compareTo(data[j -1]) < 0); j --) {
                swap(data, j, j - 1);
            }
        }
    }

    // 小优化版本
    public static <E extends Comparable<E>> void sort2(E[] data) {
        // [0, i) 之间的序列是有序的，[i, n)之间是无序的
        for(int i = 0; i < data.length; i ++) {
            E t = data[i];
            int j;
            for(j = i; j - 1 >= 0 && (t.compareTo(data[j - 1]) < 0) ; j --) {
                data[j] = data[j - 1];
            }
            data[j] = t;
        }
    }

    // 作业版本
    public static <E extends Comparable<E>> void sort3(E[] data) {
        for(int i = data.length - 1; i >= 0; i --) {
            E t = data[i];
            int j;
            for(j = i; j + 1 < data.length && (t.compareTo(data[j + 1]) > 0) ; j ++) {
                data[j] = data[j + 1];
            }
            data[j] = t;
        }
    }


    private static <E> void swap(E[] data, Integer i, Integer j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = { 10000, 100000 };
        for(int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            SortingHelper.sortTest("SelectionSort2", arr);
//            SortingHelper.sortTest("InsertionSort1", arr);
            SortingHelper.sortTest("InsertionSort3", arr);
        }


    }
}
