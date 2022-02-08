package 算法.迭代.example;

public class Sum {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7, 2,4,6, 8, 10};
        System.out.println(sum(0, arr));
    }

    public static int sum(int beginIndex, int[] array) {
        if(beginIndex == array.length ) {
            return 0;
        }
        return array[beginIndex] + sum(beginIndex + 1, array);
    }
}
