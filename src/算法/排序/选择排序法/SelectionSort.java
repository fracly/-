package 算法.排序.选择排序法;

import utils.ArrayGenerator;
import utils.SortingHelper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    private SelectionSort(){};

    // 这就是选择排序法的第一种方式，从数组中依次挑出最的小，需要注意的是，被拿出来的不能继续后续的挑选。
    public static <E extends Comparable<E>> E[] sort1(E[] data) {
//        E[] empty = (E[])new Object[data.length];
        E[] empty = (E[]) Array.newInstance(data.getClass().getComponentType(), data.length);
        // java 不支持泛型数组，通过Object来进行强制类型转化来实现, 但这里无法运行！！
        for(int i = 0; i < data.length; i ++) {
            // [0, i)是排序的，[i, n)是未排序的
            int minIndex = -1; // 表示一开始，不知道本轮最小值的index为多少，所以用-1表示
            for(int j = 0; j < data.length; j ++) {
                // 要先找基准比较的对象，minIndex为-1时无法比较，直接将它作为最小值
                if(data[j] != null && minIndex == -1)
                    minIndex = j;

                if(minIndex != -1 && data[j] != null && data[j].compareTo(data[minIndex]) < 0)
                    minIndex = j;
            }
            // 找到最小的了，将他放入新数组中，他原本所在的位置置为空
            empty[i] = data[minIndex];
            data[minIndex] = null;
        }
        return empty;
    }

    // 选择排序法的第二种方式，相比较于第一种，第二种方式不需要额外的一个数组空间，发现最小的，直接放到前面的（交换即可）
    public static <E extends Comparable<E>> void sort2(E[] data) {
        for(int i = 0; i < data.length; i ++) {
            int minIndex = i;
            for(int j = i; j < data.length; j ++) {
                if(data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }

    // 作业：改变循环体，来实现，从后往前排序
    public static <E extends Comparable> void sort3(E[] source) {
        for(int i = source.length - 1; i >= 0; i --) {
            int maxIndex = i;
            for(int j = i; j >= 0; j --) {
                if(source[j].compareTo(source[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(source, i, maxIndex);
        }
    }

    // 交换方法，将i和j所在的两个元素进行交换
    private static <E> void swap(E[] data, int i, int j) {
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        // sort1 单独测试
        Integer[] arr = {3,2,1,4,5,7,8,3,4,5,10};
        arr = SelectionSort.sort1(arr);
        System.out.println(Arrays.toString(arr));

        int[] dataSize = { 10000, 100000 };
        for(int n : dataSize) {
            // 算法.排序.选择排序法 方法1测试
//            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            Integer[] result = new Integer[n];



            // 算法.排序.选择排序法 方法2测试
//            SortingHelper.sortTest("SelectionSort2", arr);

            // 作业测试，方法3测试
//            SortingHelper.sortTest("SelectionSort3", arr);

            // 自定义类测试
            //        Product[] products = {
//                new Product(31),
//                new Product(29),
//                new Product(13),
//                new Product(87),
//                new Product(15)};
//        sort3(products);
//        for(int i = 0; i < products.length; i ++) {
//            System.out.println(products[i].price);
//        }
        }

    }


}

