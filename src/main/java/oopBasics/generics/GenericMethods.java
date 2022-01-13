package oopBasics.generics;

public class GenericMethods {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        System.out.println("Array integerArray contains:");
        printArray(intArray);   // pass an Integer array
        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray);   // pass a Double array
        System.out.println("\nArray characterArray contains:");
        printArray(charArray);   // pass a Character array
        System.out.println("----------------------------------------");
        System.out.println(maximum(1, 2, 3));
        maximum("pear", "apple", "orange");
        System.out.println("----------------------------------------");
    }

    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(" " + element);
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {  // You can multiple bounded , <T Number extends Comparable<T> etc
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }
}
