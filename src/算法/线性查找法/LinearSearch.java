package 算法.线性查找法;

import utils.Student;

public class LinearSearch {
    private LinearSearch(){}

    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,5,6,7,8};
        int res = LinearSearch.search(data, 8);
        System.out.println(res);
        System.out.println(LinearSearch.search(data, 666));

        Student[] students = {
                new Student("Alice"),
                new Student("Bob"),
                new Student("Tom")
        };

        System.out.println(search(students, new Student("wuyanfei")));
        System.out.println(search(students, new Student("Tom")));
    }

    public static <E> int search(E[] data, E target) {
        for(int i = 0; i < data.length; i ++)
            if(data[i].equals(target))
                return i;
        return -1;
    }
}
