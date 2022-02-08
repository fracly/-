package utils;

public class Product implements Comparable<Product>{
    int price;

    public Product(int price){
        this.price = price;
    }
    @Override
    public int compareTo(Product o) {
        return this.price - o.price;
    }
}
