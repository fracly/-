package 算法.排序.归并排序法;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        // 优化方案1
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, left, mid, right);
    }

    // merge 函数的作用就是将数组中的一段，[left, right] 中左右各自有序的两部分，合并成一个整体的部分。
    public static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right) {
        // 将原来的两部分有序段拷贝下来，但是会跟原来的数组产生left长度的偏移，即temp[0] == arr[left]
        E[] temp = Arrays.copyOfRange(arr, left, right + 1);

        // 用两个游标来指向原本各自有序的左右部分，在temp中获取，往原数组中填入，这个过程就叫做归并
        int i = left; int j = mid + 1;

        // k 游标用来指向排序好的元素要填入的索引位置
        for(int k = left; k <= right; k ++) {
            if(i > mid) {
                // 左边已经获取完了，取右边的值
                arr[k] = temp[j - left]; j ++;
            } else if( j > right) {
                // 右边已经获取完了，取左边的值
                arr[k] = temp[i - left]; i ++;
            } else if(temp[i - left].compareTo(temp[j - left]) <= 0) {
                // 左边比右边小（包含等于）
                arr[k] = temp[i - left]; i ++;
            } else {
                arr[k] = temp[j - left]; j ++;
            }
        }
    }
}
