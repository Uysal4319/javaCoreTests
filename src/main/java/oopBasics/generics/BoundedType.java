package oopBasics.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoundedType {
    public static void main(String[] args) {
        Random random =new Random();
        //Upper Bounded WildCards
        List<Integer> list = new ArrayList<>();
        random.ints(0, 10).limit(10).forEach(x -> list.add(x));
        System.out.println(sum(list));
        System.out.println("----------------------------------------");
        // Unbounded WildCards
        printAll(list);
        System.out.println("----------------------------------------");
        // Lower bounded WildCards
    }
    // Upper Bounded WildCards
    public static double sum(List<? extends Number> list) {
        double sum = list.stream().mapToDouble(x -> ((Number) x).doubleValue()).sum();
        return sum;
    }

    // Unbounded WildCards

    public static void printAll(List<?> list) {
        list.stream().forEach(x -> System.out.println(x));
    }

    // Lower bounded WildCards

    public static void addCat(List<? super Cat> catList) {
        System.out.println("Cat Added");
    }
    class Animal{}
    class Cat extends  Animal{}
    class Dog extends  Animal{}
}
